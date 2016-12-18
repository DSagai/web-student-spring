package my.training.site.contollers;

import javax.inject.Named;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import my.training.site.model.login.*;

@Controller
public class LoginController {

	private UserDbUtil userDbUtil;

	@Autowired
	@Named("userDAO")
	public void setUserDbUtil(UserDbUtil userDbUtil) {
		this.userDbUtil = userDbUtil;
	}


	@RequestMapping("/login")
	public ModelAndView getLoginForm() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping("/add-user-form")
	public String getNewUserForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "add-user-form";
	}

	@RequestMapping(value = "/ADD_USER", method = RequestMethod.POST)
	public String addUser(Model model,@Valid @ModelAttribute User user, BindingResult result) {

		if (result.hasErrors()) {
			return "add-user-form";
		}
		
		switch (userDbUtil.checkDuplicates(user)) {
		case "name":
			result.rejectValue("login","DuplicateKey.user.login", "This login already registered");
			return "add-user-form";
		case "email":
			result.rejectValue("email","DuplicateKey.user.email", "This email already registered");
			return "add-user-form";
		}

		
		
		userDbUtil.addUser(user);
		model.addAttribute("user", user);
		return "user-created-form";
	}
	
	@RequestMapping(value = "/activate", method = RequestMethod.GET)
	public String activateUser(Model model,@RequestParam(value = "uid") String uid) {
		String result = userDbUtil.activateUser(uid);
		model.addAttribute("result", result);
		return "user-activation-result";
	}

}
