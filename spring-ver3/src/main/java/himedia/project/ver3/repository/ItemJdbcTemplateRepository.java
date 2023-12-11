package himedia.project.ver3.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import himedia.project.ver3.dto.Item;

@Repository
public class ItemJdbcTemplateRepository implements ItemRepository{
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ItemJdbcTemplateRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 저장
	@Override
	public void save(Item item) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate)
				.withTableName("item")
				.usingGeneratedKeyColumns("id");
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", item.getName());
		parameters.put("price", item.getPrice());
		parameters.put("quantity", item.getQuantity());
		
		Number key = insertActor.executeAndReturnKey(parameters);
		item.setId(key.longValue());
	}

	// 검색 : 아이디
	@Override
	public Optional<Item> findById(Long id) {
		String sql = "select * from item where id= ?";
		List<Item> result = jdbcTemplate.query(sql,  new BeanPropertyRowMapper<Item>(Item.class), id);
		return result.stream().findAny();
	}

	// 검색 : 상품명
	@Override
	public Optional<Item> findByName(String name) {
		String sql = "select * from item where name=?";
		List<Item> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Item>(Item.class), name);
		return result.stream().findAny();
	}

	// 검색 : 전체
	@Override
	public List<Item> findAll() {
		return jdbcTemplate.query("select * from item", new BeanPropertyRowMapper<Item>(Item.class));
	}
	
	// 수정
	@Override
	public Item update(Long id, Item updateItem) {
		String sql = "update item set name=?, price=?, quantity=? where id=?";
		jdbcTemplate.update(sql, updateItem.getName(), updateItem.getPrice(), updateItem.getQuantity(), id);
		return updateItem;
	}

}
