package himedia.project.ver2.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import himedia.project.ver2.dto.Member;

//@Repository
public class MemberSpringJdbcRepository implements MemberRepository{
//	[방법 1] constructor DI
//	private final JdbcTemplate jdbcTemplate;
//	
//	@Autowired
//	public MemberSpringJdbcRepository(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

// [방법 2] field DI
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
// [방법 3] root-context 주석 처리 하고 의존성 주입하기
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MemberSpringJdbcRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Long save(Member member) {
		// DB연결, 쿼리문 생성
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate)
				.withTableName("member")
				.usingGeneratedKeyColumns("id");
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", member.getName());
		
		// 값 넣고 실행
		Number key = insertActor.executeAndReturnKey(parameters);
		
		member.setId(key.longValue());
		return member.getId();
		}

//	@Override
//	public Optional<Member> findById(Long id) {
//		String sql = "select * from member where id=" + id;
//		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Member>(Member.class))
//				.stream()
//				.findAny();
//	}
	@Override
	public Optional<Member> findById(Long id) {
		String sql = "select * from member where id = ?";
		List<Member> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Member>(Member.class), id); 
		return result.stream().findAny();
	}

	@Override
	public Optional<Member> findByName(String name) {
		String sql = "select * from member where name like ?";
		List<Member> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Member>(Member.class), name); 
		return result.stream().findAny();
	}

	@Override
	public List<Member> findAll() {
		// 쿼리결과를 리스트로 리턴해준다.
		return jdbcTemplate.query("select * from member", new BeanPropertyRowMapper<Member>(Member.class));
	}
	
}
