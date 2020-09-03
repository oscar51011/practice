package com.practice.exception;

/**
 * 自定義操作 redis 的 exception
 * @author 林聖凱
 *
 */
@SuppressWarnings("serial")
public class RedisOperationException extends RuntimeException {
	public RedisOperationException() {
        super();
    }
    public RedisOperationException(String message, Throwable cause) {
        super(message, cause);
    }
    public RedisOperationException(String message) {
        super(message);
    }
    public RedisOperationException(Throwable cause) {
        super(cause);
    }
}
