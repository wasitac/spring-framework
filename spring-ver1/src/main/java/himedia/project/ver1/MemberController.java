package himedia.project.ver1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@RequestMapping(value="/member", method = RequestMethod.GET)
	public String member() {	
		return "member/index";
	}
	
	@RequestMapping(value="/member/join", method = RequestMethod.GET)
	public String join() {
		return "member/join";
	}
}
