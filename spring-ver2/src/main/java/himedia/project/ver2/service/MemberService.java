package himedia.project.ver2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.project.ver2.dto.Member;
import himedia.project.ver2.repository.MemberRepository;

@Service
public class MemberService {
	
	private MemberRepository repository;

	@Autowired
	public MemberService(MemberRepository repository) {
		this.repository = repository;
	}
	
	public Long join(Member member) {
		System.out.println(member.getName());
		repository.save(member);
		return member.getId();
	}
	
	public Optional<Member> findId(Long id) {
		return repository.findById(id);
	}
	
	public Optional<Member> findName(String name) {
		return repository.findByName(name);
	}
	
	public List<Member> findMember() {
		return repository.findAll();
	}
}
