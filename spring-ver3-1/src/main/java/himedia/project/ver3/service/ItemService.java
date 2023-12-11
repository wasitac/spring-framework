package himedia.project.ver3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.project.ver3.dto.Item;
import himedia.project.ver3.repository.ItemRepository;

@Service
public class ItemService {
	private final ItemRepository repository;
	
	@Autowired
	public ItemService(ItemRepository repository) {
		this.repository = repository;
	}
	
	public Long save(Item item) {
		repository.add(item);
		return repository.getLastItemId();
	};
	
	public void edit(Item item) {
		repository.edit(item);
	}
	
	public List<Item> getItems() {
		return repository.getItems();
	}
	
	public Item getItemById(Long itemId) {
		return repository.getItem(itemId);
	}
}
