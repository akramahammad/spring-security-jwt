package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.User;

public interface UserRepo extends CrudRepository<User, Integer> {
	
	public User findByName(String userName); 

}
