package himedia.project.ver2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import himedia.project.ver2.domain.Item;
import himedia.project.ver2.repository.ItemRepository;

@Controller
public class ItemController {
	private final ItemRepository repository;
	
	@Autowired
	public ItemController(ItemRepository repository) {
		this.repository = repository;
		System.out.println("ItemController 실행");
	}
	
	@GetMapping("/test") 
	@ResponseBody
	public String test() {		
		Item item = repository.getRootBean();
		Item hello = repository.getServletBean();
		
		System.out.println("root-context id >> " + item.getId());
		System.out.println("root-context name >> " + item.getName());
		System.out.println("servlet-context id >> " + hello.getId());
		System.out.println("servlet-context name >> " + hello.getName());
		return "test";
	}
}