package himedia.project.ver2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.project.ver2.domain.Item;

@Repository
public class ItemRepository {
	//root-context에서 만든 bean
	private final Item item; 
	//servlet-context에서 만든 bean
	private final Item hello;

	@Autowired
	public ItemRepository(Item item, Item hello) {
		this.item = item;
		this.hello = hello;
	}
	
	public Item getServletBean() {
		return hello;
	}
	public Item getRootBean() {		
		return item;
	}
	
}
