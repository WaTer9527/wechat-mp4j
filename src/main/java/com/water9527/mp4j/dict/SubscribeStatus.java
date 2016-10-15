package com.water9527.mp4j.dict;

public enum SubscribeStatus {

	SUBSCRIBE_STATUS_YES(1, "已关注"),
	SUBSCRIBE_STATUS_NO(0, "未关注"),
	SUBSCRIBE_STATUS_CANCEL(2, "已取消关注");
	
	private int code;
	private String msg;
	
	private SubscribeStatus(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMsg() {
		return msg;
	}
	
}
