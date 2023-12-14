package himedia.project.ver3.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;

import himedia.project.ver3.dto.Item;

public interface ItemRepository {
	void save(Item item);
	Optional<Item> findById(Long id);
	List<Item> findByName(String name);
	List<Item> findAll();
//	int update(HashMap<String, Object> map);
	int update(@Param("id") Long id, @Param("updateItem") Item updateItem);
	
//	@Insert("insert into item(name, price, quantity) values(#{name}, #{price}, #{quantity})")
//	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
//	void save(Item item);
//	
//	@Select("select * from item where id = #{id}")
//	Optional<Item> findById(Long id);
//	
//	@Select("select * from item where name like '%${name}%'")
//	List<Item> findByName(String name);
//	
//	@Select("select * from item")
//	List<Item> findAll();
//	
////	@Update("update item set name=#{arg1.name}, price=#{arg1.price}, quantity=#{arg1.quantity} where id=#{arg0}")
////	void update(Long id, Item updateItem);
////	@Update("update item set name=#{param2.name}, price=#{param2.price}, quantity=#{param2.quantity} where id=#{param1}")
////	void update(Long id, Item updateItem);
//	@Update("update item set "
//			+ "name=#{updateItem.name}, "
//			+ "price=#{updateItem.price}, "
//			+ "quantity=#{updateItem.quantity} where id=#{id}")
//	int update(@Param("id") Long id, @Param("updateItem")Item updateItem);
}
