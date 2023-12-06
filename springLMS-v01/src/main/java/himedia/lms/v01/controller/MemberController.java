package himedia.lms.v01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "index";
	}
	
	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public String dashboard() {
		return "dashboard";
	}

}
