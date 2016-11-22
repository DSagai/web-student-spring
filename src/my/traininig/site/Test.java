package my.traininig.site;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import my.traininig.site.model.*;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/my/traininig/site/spring-context.xml");
		StudentDbUtil studentDbUtil = (StudentDbUtil)context.getBean("studentDAO");
		
		List<Student> students = studentDbUtil.getStudents();
		for (Student student : students){
			System.out.println(student);
		}
		System.out.println("-----------");
		Student student = studentDbUtil.loadStudent(1);
		System.out.println(student);
		
	}

}
