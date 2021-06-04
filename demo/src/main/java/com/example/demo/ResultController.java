package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/results")
public class ResultController {

	@Autowired
	private ResultRepository resultRepository;

	// get all users
	@GetMapping
	public List<Result> getAllUsers() {
		return this.resultRepository.findAll();
	}

	// get user by id
	//@GetMapping("/{id}")
	//public Result getUserById(@PathVariable (value = "id") long userId) {
	//	return this.resultRepository.findAllById(userId)
	//			.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
	//}

	// create user
	@PostMapping
	public Result createUser(@RequestBody Result user) {
		return this.resultRepository.save(user);
	}
	
}
