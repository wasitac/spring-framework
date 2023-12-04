package himedia.project.ver2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.project.ver2.dto.Member;
import himedia.project.ver2.repository.MemberRepository;
import himedia.project.ver2.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {
private final MemberRepository repository;
	
	@Autowired
	public MemberController(MemberRepository repository) {
		this.repository = repository;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String memberNew() {
		return "member/newForm";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String postNew(@ModelAttribute Member member) {
		repository.save(member);
		return "redirect:/";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Member> members = repository.findAll();
		model.addAttribute("members", members);
		return "member/memberList";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@ModelAttribute Member member, Model model) {
		Optional<Member> searchMember = null;
		if(member.getId() != null)
			searchMember = repository.findById(member.getId());
		else if(!member.getName().isEmpty())
			searchMember = repository.findByName(member.getName());
		if(searchMember.isPresent())
			model.addAttribute("member", searchMember.get());
		else
			model.addAttribute("member", new Member());
		
		return "member/search";
	}

}
