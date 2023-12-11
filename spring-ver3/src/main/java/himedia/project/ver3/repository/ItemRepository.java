package himedia.project.ver3.repository;

import java.util.List;
import java.util.Optional;

import himedia.project.ver3.dto.Item;

public interface ItemRepository {
	void save(Item item);
	Optional<Item> findById(Long id);
	Optional<Item> findByName(String name);
	List<Item> findAll();
	Item update(Long id, Item updateItem);
}
