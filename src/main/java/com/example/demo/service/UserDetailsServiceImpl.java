package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user =userRepo.findByName(username);
		if(user==null) {
			throw new UsernameNotFoundException("User details not found for user Id ::"+username);
		}
//		if(username.equals("admin")) {
//			return new org.springframework.security.core.userdetails.User("admin", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new ArrayList<>());
//		}
//		else {
//			throw new UsernameNotFoundException("User details not found for user Id ::"+username);
//		}
		return new org.springframework.security.core.userdetails.User(user.getName(), 
				user.getPassword(), user.getRoles());
	}

}
