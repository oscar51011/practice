package com.practice.security.dto;

/**
 * 取得token的參數
 * @author 林聖凱
 *
 */
public class AuthRequest {
	
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
