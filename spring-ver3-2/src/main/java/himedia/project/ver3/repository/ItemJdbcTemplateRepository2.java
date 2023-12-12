package himedia.project.ver3.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import himedia.project.ver3.dto.Item;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ItemJdbcTemplateRepository2 implements ItemRepository{
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ItemJdbcTemplateRepository2(JdbcTemplate jdbcTemplate) {
		System.out.println("[syso] repository 실행");
		log.info("[log] repository 실행");
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private RowMapper<Item> itemRowMapper(){
		return new RowMapper<Item>() {

			@Override
			public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
				Item item = new Item();
				item.setId(rs.getLong("id"));
				item.setName(rs.getString("name"));
				item.setPrice(rs.getInt("price"));
				item.setQuantity(rs.getInt("quantity"));
				return item;
			}
			
		};
	}

	@Override
	public void save(Item item) {
		// TODO Auto-generated method stub
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
				.withTableName("item")
				.usingGeneratedKeyColumns("id");
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", item.getName());
		parameters.put("price", item.getPrice());
		parameters.put("quantity", item.getQuantity());
		
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
		item.setId(key.longValue());
	}

	@Override
	public Optional<Item> findById(Long id) {
		// TODO Auto-generated method stub/
		String sql = "select * from item where id = ?";
		List<Item> result = jdbcTemplate.query(sql, itemRowMapper(), id);
		return result.stream().findAny();
	}

	@Override
	public Optional<Item> findByName(String name) {
		String sql = "select*from item where name like ?";
		List<Item> result = jdbcTemplate.query(sql, itemRowMapper(), name);
		return result.stream().findAny();
	}

	@Override
	public List<Item> findAll() {
		return jdbcTemplate.query("select * from item", itemRowMapper());
	}

	@Override
	public Item update(Long id, Item updateItem) {
		String sql = "update item set name=?, price=?, quantity=? where id=?";
		int result = jdbcTemplate.update(sql, 
				updateItem.getName(),
				updateItem.getPrice(),
				updateItem.getQuantity(),
				id);
		log.info("update 실행 결과 >> {}", result);
		return findById(id).get();
	}
	
}
