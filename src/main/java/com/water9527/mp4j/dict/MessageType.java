package com.water9527.mp4j.dict;

public enum MessageType {
	
	text("文本消息"),
	news("图文"),
	voice("语音消息"),
	image("图片消息"),
	video("视频消息"),
	shortvideo("小视频消息"),
	location("地理位置消息"),
	link("链接消息"),
	event("事件推送");
	
	private String msg;
	
	private MessageType(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
}
