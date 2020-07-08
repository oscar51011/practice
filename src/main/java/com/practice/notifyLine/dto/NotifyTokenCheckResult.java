package com.practice.notifyLine.dto;
/**
 * 檢查Line通知 token 的狀態
 * @author 林聖凱
 *
 */
public class NotifyTokenCheckResult {
	/**
	 * Value according to HTTP status code
	 * 200: Success・Access token valid
	 * 401: Invalid access token
	 */
	private int status;
	/**
	 * 200: ok
	 * 401: Invalid access token
	 */
	private String message;
	/**
	 * USER: target is user
	 * GROUP : target is group
	 */
	private String targetType;
	/**
	 * 	If the notification target is a user, displays user name.
	 *  - If acquisition fails, displays "null."
	 *  If the notification target is a group, displays group name.
	 *  - If the target user has already left the group, displays "null."
	 */
	private String target;
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
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
}
