package com.water9527.mp4j.modules.message;

import java.util.Map;

import com.water9527.mp4j.modules.message.processor.NullProcessor;
import com.water9527.mp4j.modules.message.processor.Processor;

public class EventMessage extends Message {
	
	private static Processor processor = new NullProcessor();
	
	private String eventType;
	
	private String openId;

	public EventMessage(Map<String, String> requestMap) {
		super(requestMap);
		setEventType(requestMap.get("Event"));
		setOpenId(requestMap.get("FromUserName"));
	}
	
	public static void registerProcessor(Processor pro) {
		processor = pro;
	}

	@Override
	public String process() {
		processor.execute(this);
		return "";
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

}
