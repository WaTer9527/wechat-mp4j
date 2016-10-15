package com.water9527.mp4j.base;

public class WechatException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WechatException(String message) {
		super(message);
	}
	
	public WechatException(String message, Throwable cause) {
		super(message, cause);
	}
}
