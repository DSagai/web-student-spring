package my.training.site.model.login;

import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDAO")
public class UserDbUtil {
	private NamedParameterJdbcTemplate jdbc;
	private PasswordEncoder passwordEncoder;

	@Autowired
	@Named("passwordEncoder")
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Autowired
	@Named("dataSource")
	public void setDataSource(DataSource dataSource) {
		jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	@Transactional
	public void addUser(User user) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("login", user.getLogin());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		params.addValue("email", user.getEmail());
		params.addValue("enabled", user.isEnabled());
		params.addValue("authority", user.getAuthority());
		String sql = "insert into sec_users(username, password, email, enabled, role) "
				+ "select :login, :password, :email, :enabled, id " + "from sec_roles "
				+ "where role_name = :authority";
		jdbc.update(sql, params);
	}

	public String checkDuplicates(User user) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		String sql = "call check_duplicates(:login,:email)";
		SqlRowSet rowSet = jdbc.queryForRowSet(sql, params);
		if (rowSet.next()) {
			if (rowSet.getInt("username_exists") > 0) {
				return "name";
			}
			if (rowSet.getInt("email_exists") > 0) {
				return "email";
			}
		}
		return "";
	}
}
