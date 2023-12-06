package himedia.project.ver2.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import himedia.project.ver2.dto.Member;

//@Repository
public class MemberMemoryRepository implements MemberRepository {

	private static Map<Long, Member> store = new HashMap<Long, Member>();
	private static Long sequence = 0L;

	@Override
	public Long save(Member member) {
		// TODO Auto-generated method stub
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member.getId();
	}

	@Override
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream().filter(v -> v.getName().equals(name)).findAny();
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<Member>(store.values());
	}

}
