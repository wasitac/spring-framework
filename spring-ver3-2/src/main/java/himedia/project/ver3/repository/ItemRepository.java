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

//	@Insert("insert into item(name, price, quantity) values(#{name}, #{price}, #{quantity})")
//	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
//	void save(Item item);
//	@Select("select * from item where id=#{id}")
//	Optional<Item> findById(Long id);
//	@Select("select * from item where name=#{name}")
//	Optional<Item> findByName(String name);
//	@Select("select * from item")
//	List<Item> findAll();
//	@Update("update item set name=#{name}, price=#{price}, quantity=#{quantity} where id=#{id}")
//	int update(Item item);
	
}
