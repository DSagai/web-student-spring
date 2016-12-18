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
		String sql = "insert into sec_users(username, password, email, enabled, role, UID) "
				+ "select :login, :password, :email, :enabled, id, UNHEX(REPLACE(UUID(), '-', '')) " + "from sec_roles "
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

	public String activateUser(String uid) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("uid", uid);
		String sql = "update sec_users "
				+ "set enabled = 1 "
				+ "where enabled = 0 "
				+ "and UID = X:uid";
		if (jdbc.update(sql, params) == 1){
			sql = "select username from sec_users where UID = X:uid ";
			String userName = jdbc.queryForObject(sql, params, String.class);
			return String.format("User %s succesfully activated.", userName);
		}
		return "Invalid activation request.";
	}

}
