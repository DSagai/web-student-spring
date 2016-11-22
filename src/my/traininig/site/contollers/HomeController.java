package my.traininig.site.contollers;

import java.util.List;

import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import my.traininig.site.model.*;

@Controller
public class HomeController {
	
	private StudentDbUtil studentDbUtil;
	

	@Autowired
	@Named("studentDAO")
	public void setStudentDbUtil(StudentDbUtil studentDbUtil) {
		this.studentDbUtil = studentDbUtil;
	}


	@RequestMapping("/home")
	public String getHome(){
		return "home";
	}
	
	@RequestMapping("/")
	public String getStudentList(HttpServletRequest request){
		List<Student> students = studentDbUtil.getStudents();
		request.setAttribute("STUDENT_LIST", students);
		return "list-students";
	}
}
