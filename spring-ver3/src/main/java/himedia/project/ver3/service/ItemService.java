package himedia.project.ver3.service;

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
}
