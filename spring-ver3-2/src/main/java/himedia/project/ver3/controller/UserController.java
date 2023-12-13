package himedia.project.ver3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.project.ver3.service.ItemService;

@Controller
@RequestMapping("store/user")
public class UserController {
//	private final UserService service;
//	
//	@Autowired
//	public UserController(UserService service) {
//		this.service = service;
//	}
	
	@GetMapping("/logIn")
	public String logIn() {
		return "/user/logIn";
	}

	//	@PostMapping()
//	public String logIn(@ModelAttribute User user, Model model) {
//		service.logIn(user);
//		model.addAttribute(user);
//	}
}
