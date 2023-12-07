package himedia.project.ver2.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import himedia.project.ver2.dto.Member;

public interface MemberRepository {

	@Insert("insert into member(name) values (#{name})")
	Long save(Member member);
	
	@Select("select * from member where id=#{id}")
	Optional<Member> findById(Long id);
	
	@Select("select * from member where name like #{name} limit 1")
	Optional<Member> findByName(String name);
		
	@Select("select * from member")
	List<Member> findAll();
}

