package himedia.project.ver3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.project.ver3.dto.Item;
import himedia.project.ver3.service.ItemService;

@Controller
@RequestMapping("/store")
public class ItemController {
	
	private final ItemService service;
	
	@Autowired
	public ItemController(ItemService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	
	@GetMapping("/items")
	public String items(@RequestParam Long itemId, Model model) {
		if(itemId == null) {
			return "store/items";
		}
		model.addAttribute("itemId", itemId);
		return "store/item";
	}

	@GetMapping("/add")
	public String addForm() {
		return "store/addForm";
	}
	@PostMapping("/add")
	public String add(@RequestParam Item item, Model model) {
		model.addAttribute(service.save(item));
		return "redirect:/store/items";
	}

	@GetMapping("/edit")
	public String editForm(@RequestParam Long itemId) {
		return "store/editForm";
	}
	@PostMapping("/edit")
	public String edit(@RequestParam Item item, Model model) {
		model.addAttribute("item", item);
		return "redirect:/store/items";
	}
}
