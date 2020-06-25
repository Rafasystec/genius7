package com.genius7.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genius7.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);
}
