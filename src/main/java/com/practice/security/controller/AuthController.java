package com.practice.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.security.dto.AuthRequest;
import com.practice.security.dto.AuthResponse;
import com.practice.security.util.JwtUtil;

@RestController
public class AuthController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> getGenerateToken(@RequestBody AuthRequest authRequest) throws Exception {
				
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
		);		
		}catch(Exception e) {
			throw new Exception("帳密不合法",e);
		}
		
		String token = jwtUtil.generateToken(authRequest.getUserName());
		
		return ResponseEntity.ok(new AuthResponse(token));
		
	}
	
}
