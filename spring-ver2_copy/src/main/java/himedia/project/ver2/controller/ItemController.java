package himedia.project.ver2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import himedia.project.ver2.domain.Item;

@Controller
public class ItemController {
	private final Item item;
	
	@Autowired
	public ItemController(Item item) {
		this.item = item;
		System.out.println("ItemController 실행");
		System.out.println("itemController item.getName() >> " + item.getName());
	}
	
	@GetMapping("/id")
	@ResponseBody
	public String id() {
		return item.getName();
	}
}