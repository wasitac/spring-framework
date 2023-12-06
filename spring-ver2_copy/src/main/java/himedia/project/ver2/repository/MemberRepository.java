package himedia.project.ver2.repository;

import java.util.List;
import java.util.Optional;

import himedia.project.ver2.dto.Member;

public interface MemberRepository {
	// [과제3] interface MemberRepository의 save method 
	// 리턴형 변경 후 발생 에러 해결
	// 해당 인터페이스를 상속받은 구현체의 save메소드 리턴형을 Long으로 변경
//	Member save(Member member);
	Long save(Member member);
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();
}
