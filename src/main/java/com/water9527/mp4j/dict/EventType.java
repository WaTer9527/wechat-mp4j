package com.water9527.mp4j.dict;

public enum EventType {

	subscribe("关注或扫描带参数二维码关注"),
	unsubscribe("取消关注"),
	SCAN("扫描带参数二维码（用户已关注）"),
	LOCATION("上报地理位置"),
	CLICK("点击菜单拉取消息"),
	VIEW("点击菜单跳转链接");
	
	private String msg;
	
	private EventType(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
	
}
