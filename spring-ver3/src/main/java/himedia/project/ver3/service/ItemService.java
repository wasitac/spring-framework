package himedia.project.ver3.service;

import java.util.List;
import java.util.Optional;

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
	
	// 저장
	public void saveItem(Item item) {
		repository.save(item);
	}
		
	// 검색 : 아이디
	public Optional<Item> findId(Long id) {
		return repository.findById(id);
	}
	
	// 검색 : 상품명
	public List<Item> findName(String name) {
		return repository.findByName(name);
	}
	
	// 검색 : 전체
	public List<Item> findAll() {
		return repository.findAll();
	}
	
	// 수정
	public int updateItem(Long id, Item updateItem) {
		return repository.update(id, updateItem);
	}
	
}
