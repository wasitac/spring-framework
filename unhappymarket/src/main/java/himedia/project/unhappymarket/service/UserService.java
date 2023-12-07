package himedia.project.unhappymarket.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.project.unhappymarket.dto.User;
import himedia.project.unhappymarket.repository.UserRepository;

@Service
public class UserService {
	private UserRepository repository;
	
	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public Boolean save(User user) {
		//중복되는 아이디 없으면 가입
		Optional<User> targetId = repository.findById(user.getId());
		if(targetId.isPresent()) {
			System.out.println("중복된 아이디 있음");
			return false;
		}
		repository.join(user);
		return true;
	}
	
	public Optional<User> isUser(User user) {
		//아이디, 비밀번호 체크
		Optional<User> userAccount = repository.login(user);
		return userAccount;
	}
}
