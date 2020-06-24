package com.genius7.rule;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.genius7.model.User;
import com.genius7.repository.UserRepo;

@Service
public class UserRule {

	@Autowired
	private UserRepo userRepo;
	
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public Page<User> findAll(Pageable pagination) {
		return userRepo.findAll(pagination);
	}
	
	public User find(Long id) {		
		Optional<User> found = userRepo.findById(id);
		if(found.isPresent()) {
			return found.get();
		}else {
			return User.NOT_FOUND;
		}
	}
	
	public void delete(Long id) {
		userRepo.deleteById(id);
	}
	
	public User insert(User user) {
		return userRepo.save(user);
	}
}
