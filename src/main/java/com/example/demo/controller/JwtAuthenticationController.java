package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.entity.JwtRequest;
import com.example.demo.entity.JwtResponse;

@RestController
public class JwtAuthenticationController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public JwtResponse authenticateUser(@RequestBody JwtRequest request) throws Exception {
		
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
					request.getPassword()));
		}
		catch(BadCredentialsException e) {
			throw new Exception("Invalid Credentials",e);
			
		}
		
		UserDetails userDetails= userDetailsService.loadUserByUsername(request.getUsername());
		String token=jwtUtil.generateToken(userDetails);
		return new JwtResponse(token);
		
	}

}
