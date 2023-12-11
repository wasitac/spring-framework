package himedia.project.ver3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.project.ver3.dto.Item;
import himedia.project.ver3.service.ItemService;

@Controller
@RequestMapping("/store/items")
public class ItemController {
	
	private final ItemService service;
	
	@Autowired
	public ItemController(ItemService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	@GetMapping()
	public String items(Model model) {
		model.addAttribute("items", service.getItems());
		return "store/items";
	}
	
	@GetMapping("/{itemId}")
	public String item(@PathVariable("itemId") Long itemId, Model model) {
		Item item = service.getItemById(itemId);
		model.addAttribute("item", item);
		return "store/item";
	}

	@GetMapping("/add")
	public String addForm() {
		return "store/addForm";
	}
	@PostMapping("/add")
	public String add(@ModelAttribute Item item, Model model) {
		service.save(item);
		return "redirect:/store/items/"+item.getItemId();
	}

	@GetMapping("/{itemId}/edit")
	public String editForm(@PathVariable("itemId") Long itemId, Model model) {
		Item item = service.getItemById(itemId);
		model.addAttribute("item", item);
		return "store/editForm";
	}
	@PostMapping("/{itemId}/edit")
	public String edit(@ModelAttribute Item item, Model model) {
		service.edit(item);
		return "redirect:/store/items/"+item.getItemId();
	}
}
