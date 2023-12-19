// package himedia.project.ver3.controller;
//
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import himedia.project.ver3.dto.Member;
//import himedia.project.ver3.mapper.MemberMapper;
//import lombok.RequiredArgsConstructor;
//
//@RestController //@Controller + @ResponseBody
//@RequestMapping("/members")
//@RequiredArgsConstructor
//public class MemberController {
//	private final MemberMapper mapper;
//	
////	@Autowired
////	public MemberController(MemberMapper mapper) {
////		this.mapper = mapper;
////	}
//	@GetMapping("/all")
//	public List<Member> all() {
//		return mapper.findAll();
//	}
//	
//	@GetMapping("/name")
//	public List<Member> findName(@RequestParam String name) {
//		return mapper.findByName(name);
//	}
//	
//	@GetMapping("/id")
//	public Member findId(@RequestParam Long id) {
//		return mapper.findById(id).get();
//	}
//}
