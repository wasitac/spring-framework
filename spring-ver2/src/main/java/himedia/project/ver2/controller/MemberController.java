package himedia.project.ver2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.project.ver2.dto.Member;
import himedia.project.ver2.repository.MemberMemoryRepository;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	private static MemberMemoryRepository repository = new MemberMemoryRepository();
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String memberNew() {
		return "member/newForm";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String postNew(@RequestParam String name) {
		Member member = new Member();
		member.setName(name);
		repository.save(member);
		return "redirect:/";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("members", repository.findAll());
		return "member/memberList";
	}

}
