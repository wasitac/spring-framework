package himedia.project.ver3.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import himedia.project.ver3.dto.Item;

public interface ItemRepository {
	@Insert("insert into item values(#{name}, #{price}, #{count})")
	public void add(Item item);
	@Update("update")
	public void edit(Long itemId);
	@Select("select * from item where id=#{id}")
	public Item getItem(Long itemId);
	@Select("select * from item")
	public List<Item> getItems();
	@Select("select itemId from item ORDER BY itemId DESC LIMIT 1")
	public Long getLastItemId();
}
