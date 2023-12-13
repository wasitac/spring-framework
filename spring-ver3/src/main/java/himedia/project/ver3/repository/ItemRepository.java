package himedia.project.ver3.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import himedia.project.ver3.dto.Item;

public interface ItemRepository {
	@Insert("insert into item(name, price, quantity) values(#{name}, #{price}, #{quantity})")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	void save(Item item);
	
	@Select("select * from item where id = #{id}")
	Optional<Item> findById(Long id);
	
	@Select("select * from item where name like '%${name}%'")
	List<Item> findByName(String name);
	
	@Select("select * from item")
	List<Item> findAll();
	
//	@Update("update item set name=#{arg1.name}, price=#{arg1.price}, quantity=#{arg1.quantity} where id=#{arg0}")
//	void update(Long id, Item updateItem);
//	@Update("update item set name=#{param2.name}, price=#{param2.price}, quantity=#{param2.quantity} where id=#{param1}")
//	void update(Long id, Item updateItem);
	@Update("update item set name=#{updateItem.name}, price=#{updateItem.price}, quantity=#{updateItem.quantity} where id=#{id}")
	void update(@Param("id") Long id, @Param("updateItem")Item updateItem);
}
