package himedia.project.ver3.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import himedia.project.ver3.dto.Item;

public interface ItemRepository {
	@Insert("insert into item(name, price, count) values(#{name}, #{price}, #{count})")
	@Options(useGeneratedKeys = true, keyProperty = "itemId", keyColumn = "itemId")
	public void add(Item item);
	@Update("update item set name=#{name}, price=#{price}, count=#{count} where itemId=#{itemId}")
	public void edit(Item item);
	@Select("select * from item where itemId=#{itemId}")
	public Item getItem(Long itemId);
	@Select("select * from item")
	public List<Item> getItems();
	@Select("select itemId from item ORDER BY itemId DESC LIMIT 1")
	public Long getLastItemId();
}
