package com.practice.notifyLine.dto;

/**
 * Line通知回傳的 response
 * API doc : https://notify-bot.line.me/doc/en/
 * @author 林聖凱
 *
 */
public class NotifyResult {
	/**
	 * Value according to HTTP status code
	 *	200: Success
	 *	400: Bad request
	 *	401: Invalid access token
	 */
	private int status;
	/**
	 * 200: ok
	 * 401: Invalid access token
	 */
	private String message;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
