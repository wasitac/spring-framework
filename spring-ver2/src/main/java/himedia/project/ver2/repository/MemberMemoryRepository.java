package himedia.project.ver2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

import himedia.project.ver2.dto.Member;

public class MemberMemoryRepository implements MemberRepository {

	private static Map<Long, Member> store = new HashMap<Long, Member>();
	private static Long sequence = 0L;

	@Override
	public Member save(Member member) {
		// TODO Auto-generated method stub
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public Optional<Member> findByName(String name) {
		return null;
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<Member>(store.values());
	}

}
