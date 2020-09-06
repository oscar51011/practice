package com.practice.security.dto;

/**
 * 取得 token 回傳值
 * @author 林聖凱
 *
 */
public class AuthResponse {
	
	private String token;
	
	public AuthResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}	
}
