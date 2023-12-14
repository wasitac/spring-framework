package himedia.project.ver3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TestController {
	// http://localhost:8080/ver3/path?name=hello
	@GetMapping("/path")
	public String pathRequest(String name, RedirectAttributes redirectAttributes) {
//		redirectAttributes.addAttribute("name", name);
//		redirectAttributes.addAttribute("status", true);
//		redirectAttributes.addAttribute("id", 500);
		redirectAttributes.addFlashAttribute(name, redirectAttributes);
		return "redirect:/test";
	}
	
	@GetMapping("/test")
	public String test(String name, Model model) {
		model.addAttribute("name", name);
		return "store/test";
	}

	//	@GetMapping("/path")
//	public String pathRequest(String name) {
//		String url = UriComponentsBuilder.fromPath("test")
//				.queryParam("name", name)
//				.toUriString();
//		log.info("name : {}", name);
//		return "redirect:/" + url;
//	}
//	
//	@GetMapping("/test")
//	public String test(String name, Model model) {
//		model.addAttribute("name", name);
//		return "store/test";
//	}
	
	
//	@GetMapping("/path")
//	public String pathRequest(String name) throws UnsupportedEncodingException {
//		String encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8);
//		log.info("name : {}", name);
//		return "redirect:/test?name=" + encodedName;
//	}
//	
//	@GetMapping("/test")
//	public String test(String name, Model model) throws UnsupportedEncodingException{
//		String decodedName = URLDecoder.decode(name, "UTF-8");
//		model.addAttribute("name", decodedName);
//		return "store/test";
//	}
}
