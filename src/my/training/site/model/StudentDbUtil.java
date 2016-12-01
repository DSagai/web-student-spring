package my.training.site.model;


import java.util.List;

import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("studentDAO")
public class StudentDbUtil {
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	@Named("dataSource")
	public void setDataSource(DataSource dataSource){
		jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Student> getStudents() {
		String sql = "select * from student";
		return jdbc.query(sql, new StudentMapper());
	}



	public boolean addStudent(Student student){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(student);
		String sql = "insert into student(first_name, last_name, email) values (:firstName, :lastName, :email)";
		return jdbc.update(sql, params) == 1;
	}
	
	@Transactional
	public void addStudent(List<Student> students){
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(students.toArray());
		String sql = "insert into student(first_name, last_name, email) values (:firstName, :lastName, :email)";
		jdbc.batchUpdate(sql, params);
	}
	
	

	public boolean updateStudent(Student student){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(student);
		String sql = "update student set first_name = :firstName, last_name = :lastName, email = :email where id = :id";
		System.out.println(params);
		return jdbc.update(sql, params) == 1;
	}

	public Student loadStudent(int id){
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
		String sql = "select * from student where id = :id";
		return (Student)jdbc.queryForObject(sql, namedParameters, new StudentMapper());
	}

	public boolean deleteStudent(int id){
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
		String sql = "delete from student where id = :id";
		return jdbc.update(sql, namedParameters) != 0;
	}
	
	public boolean deleteStudent(Student student){
		if (student == null)
			return false;
		return deleteStudent(student.getId());
	}
	
}
