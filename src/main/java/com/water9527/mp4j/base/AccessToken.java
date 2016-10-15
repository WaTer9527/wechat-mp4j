package com.water9527.mp4j.base;

/**
 * AccessToken实体类
 */
public class AccessToken {
	
	/**
	 * 获取到的凭证
	 */
	private String token;
	
	/**
	 * 凭证有效时间，单位：秒
	 */
	private Integer expiresIn;
	
	/**
	 * 凭证到期时间，单位：毫秒
	 */
	private Long expiresTime;
	
	/**
	 * JS接口的临时票据
	 */
	private String ticket;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	public Long getExpiresTime() {
		return expiresTime;
	}

	public void setExpiresTime(Long expiresTime) {
		this.expiresTime = expiresTime;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
}
