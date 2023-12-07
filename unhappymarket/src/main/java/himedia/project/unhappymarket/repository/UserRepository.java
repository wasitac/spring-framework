package himedia.project.unhappymarket.repository;

import java.util.Optional;

import himedia.project.unhappymarket.dto.User;

public interface UserRepository {
	void join(User user);
	Optional<User> findById(String id);
	Optional<User> login(User user);
}
