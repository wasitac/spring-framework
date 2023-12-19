package himedia.project.ver3.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import himedia.project.ver3.dto.Member;

@Mapper
public interface MemberMapper {
	void save(Member member);
	
	@Select("select * from member where id = #{id}")
	Optional<Member> findById(Long id);
	
	@Select("select * from member where name like '%${name}%'")
	List<Member> findByName(String name);
	
	@Select("select * from member")
	List<Member> findAll();
	
	@Update("update member set "
			+ "name=#{member.name}, info=#{member.info}"
			+ "where id=#{id}")
	int update(@Param("id") Long id, @Param("member") Member member);
}
