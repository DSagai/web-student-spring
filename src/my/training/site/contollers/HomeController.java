package my.training.site.contollers;

import java.util.*;

import javax.inject.Named;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import my.training.site.model.*;

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
	
	@RequestMapping("/add-form")
	public String addStudentForm(){
		return "add-student-form";
	}
	
	@RequestMapping(value="/ADD", method=RequestMethod.POST)
	public String addStudent(Model model,@ModelAttribute Student student){
		studentDbUtil.addStudent(student);
		return "redirect:/";
	}
	
	@RequestMapping("/update-form")
	public ModelAndView getUpdateForm(@RequestParam(value = "id") int id){
		ModelAndView mv = new ModelAndView("update-student-form");
		Map<String,Object> model = mv.getModel();
		Student student = studentDbUtil.loadStudent(id);
		model.put("STUDENT", student);
		return mv;
	}
	
	@RequestMapping(value="/UPDATE", method=RequestMethod.POST)
	public String updateStudent(Model model,@ModelAttribute Student student){
		studentDbUtil.updateStudent(student);
		return "redirect:/";
	}
	
	@RequestMapping("/DELETE")
	public String deleteStudent(@RequestParam(value = "id") int id){
		studentDbUtil.deleteStudent(id);
		return "redirect:/";
	}
}
