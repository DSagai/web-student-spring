package my.traininig.site.contollers;

import java.util.*;

import javax.inject.Named;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView getStudentList(){
		List<Student> students = studentDbUtil.getStudents();
		ModelAndView mv = new ModelAndView("list-students");
		Map<String,Object> model = mv.getModel(); 
		model.put("STUDENT_LIST", students);
		
		return mv;
	}
}
