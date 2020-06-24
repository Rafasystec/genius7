package com.genius7.controller;

//import java.util.List;

//import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genius7.model.User;
import com.genius7.request.RequestUser;
import com.genius7.response.ResponseUser;
/**
 * Use this class as a example And don forget to note it as @RestController if you do not do that , its will not work
 * @author Rafael Rocha
 *
 */
import com.genius7.rule.UserRule;
@RestController
@RequestMapping("/user")
public class UserController extends SuperController{
	
	@Autowired
	UserRule userRule;

	@PostMapping
	@Transactional
	public ResponseEntity<ResponseUser> save(@RequestBody @Valid RequestUser request) {
		//Save the user
		User user = userRule.insert(new User()
				.setEmail(request.getEmail())
				.setPwd(request.getPwd())
				.setType(request.getType()));
		
		ResponseUser response = new ResponseUser(user);
				
		
		return ResponseEntity.ok(response);
	}
	
//	@GetMapping
//	public ResponseEntity<List<ResponseUser>> get() {
//		List<User> list = userRule.findAll();
//		return ResponseEntity.ok(new ResponseUser(list).getUsers());
//	}
	
	@GetMapping("{id}")
	public ResponseEntity<ResponseUser> get(@PathVariable Long id) {
		User user = userRule.find(id);
		return ResponseEntity.ok(new ResponseUser(user));
	}
	
	/**
	 * With pagination
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@GetMapping("{page}/{pageSize}")
	public ResponseEntity<Page<ResponseUser>> get(@PathVariable int page, @PathVariable int pageSize) {
		Pageable pagination = PageRequest.of(page, pageSize);
		/*
		 * -------------------------------------------------------------------------------------
		 * NOTE: Return the Page could be not so good, so you can get only specific data from it.
		 * ------------------------------------------------------------------------------------- 
		 */
		Page<User> list = userRule.findAll(pagination);
		return ResponseEntity.ok(ResponseUser.toList(list));
	}
	
	/**
	 * For this case you need to pass like query param
	 * localhost:8080/user?page=0&size=2
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Page<ResponseUser>> get(Pageable pageable) {
		
		/*
		 * -------------------------------------------------------------------------------------
		 * NOTE: Return the Page could be not so good, so you can get only specific data from it.
		 * ------------------------------------------------------------------------------------- 
		 */
		Page<User> list = userRule.findAll(pageable);
		return ResponseEntity.ok(ResponseUser.toList(list));
	}
	
}
