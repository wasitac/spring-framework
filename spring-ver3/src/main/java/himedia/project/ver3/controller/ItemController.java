package himedia.project.ver3.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.project.ver3.dto.Item;
import himedia.project.ver3.service.ItemService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/store/items")
public class ItemController {
	
	private final ItemService service;
	
	@Autowired
	public ItemController(ItemService service) {
		this.service = service;
	}
	
	// 상품 목록
	@GetMapping()
	public String items(Model model) {
		model.addAttribute("items", service.findAll());
		return "store/items";
	}
	
	// 상품 상세
	@GetMapping("/{id}")
	public String item(@PathVariable("id") Long id, Model model) {
		Optional<Item> item = service.findId(id);
		model.addAttribute("item", item.get());
		return "store/item";
	}
	
	// 상품 등록 폼
	@GetMapping("/add")
	public String addForm() {
		return "store/addForm";
	}
	
	// 상품 등록
	@PostMapping("/add")
	public String postAdd(@ModelAttribute Item item, Model model) {
		service.saveItem(item);
		return "redirect:/store/items/"+item.getId();
	}
	
	// 상품 수정 폼
	@GetMapping("/{id}/edit")
	public String editForm(@PathVariable("id") Long id, Model model) {
		Optional<Item> item = service.findId(id);
		model.addAttribute("item", item.get());
		return "store/editForm";
	}
	
	// 상품 수정
	@PostMapping("/{id}/edit")
	public String postEdit(@PathVariable("id") Long id, 
			@ModelAttribute Item item, Model model) {
		service.updateItem(id, item);
		return "redirect:/store/items/"+id;
	}
	
	// 상품 검색
	@GetMapping("/search")
	public String search(@ModelAttribute String name) {
		Item item = new Item();
		Optional<Item> result = service.findName(name);
		if (result.isPresent()) {
			item = result.get();
			log.info(item.getId().toString());}
		return "store/items/" + item.getId();
	}
}
