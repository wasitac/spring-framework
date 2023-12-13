package himedia.project.ver3.controller;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import himedia.project.ver3.dto.Item;
import himedia.project.ver3.service.ItemService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/store")
public class ItemController {
	
	private final ItemService service;
	
	@Autowired
	public ItemController(ItemService service) {
		this.service = service;
	}
	
	// 상품 목록
	@GetMapping("/items")
	public String items(Model model) {
		model.addAttribute("items", service.findAll());
		return "store/items";
	}
	
	// 상품 상세
	@GetMapping("/items/{id}")
	public String item(@PathVariable("id") Long id, Model model) {
		Optional<Item> item = service.findId(id);
		model.addAttribute("item", item.get());
		return "store/item";
	}
	
	// 상품 등록 폼
	@GetMapping("/items/add")
	public String addForm() {
		return "store/addForm";
	}
	
	// 상품 등록
	@PostMapping("/items/add")
	public String postAdd(@ModelAttribute Item item, Model model) {
		service.saveItem(item);
		return "redirect:/store/items/"+item.getId();
	}
	
	// 상품 수정 폼
	@GetMapping("/items/{id}/edit")
	public String editForm(@PathVariable("id") Long id, Model model) {
		Optional<Item> item = service.findId(id);
		model.addAttribute("item", item.get());
		return "store/editForm";
	}
	
	// 상품 수정
	@PostMapping("/items/{id}/edit")
	public String postEdit(@PathVariable("id") Long id, Item updateItem) {
		service.updateItem(id, updateItem);
		return "redirect:/store/items/" + id;
	}
	
	// 상품 검색
	@GetMapping("/items/search")
	public String search(@ModelAttribute("search") String search, Model model) {
		List<Item> result = service.findName(search);
		model.addAttribute("items", result);
		return "store/items";
	}
	
	// http://localhost:8080/ver3/store/path?name=hello
	@GetMapping("/path")
	public String pathRequest(String name) {
		String url = UriComponentsBuilder.fromPath("/store/test")
				.queryParam("name", name)
				.toUriString();
		log.info("name : {}", name);
		return "redirect:" + url;
	}
	
	@GetMapping("/test")
	public String test(String name, Model model) {
		model.addAttribute("name", name);
		return "store/test";
	}
//	@GetMapping("/path")
//	public String pathRequest(String name) throws UnsupportedEncodingException {
//		String encodedName = URLEncoder.encode(name, "UTF-8");
//		log.info("name : {}", name);
//		return "redirect:/store/test?name=" + encodedName;
//	}
//	
//	@GetMapping("/test")
//	public String test(String name, Model model) throws UnsupportedEncodingException{
//		String decodedName = URLDecoder.decode(name, "UTF-8");
//		model.addAttribute("name", decodedName);
//		return "store/test";
//	}
}
