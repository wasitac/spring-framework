package himedia.project.unhappymarket.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.project.unhappymarket.dto.User;
import himedia.project.unhappymarket.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private final UserService service;
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/join")
	public String joinForm() {
		return "/user/joinForm";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute User user) {
		if(service.save(user))
			return "redirect:/";
		return "redirect:/user/join";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, Model model) {
		System.out.println(user.getName());
		Optional<User> userAccount = service.isUser(user);
		System.out.println(userAccount.get().getName());
		if(userAccount.isPresent())
			model.addAttribute(userAccount.get());
		
		return "/user/loginResult";
	}
}
