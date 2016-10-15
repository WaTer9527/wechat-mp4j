/**
 * @File : Event.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月1日
 * @Version : V1.0
 * @Copyright : 幸福时代网络科技（北京）股份有限公司
 */
package com.water9527.mp4j.modules.message.event;

import java.util.Map;

import com.water9527.mp4j.base.WechatException;
import com.water9527.mp4j.modules.message.EventMessage;

public abstract class Event {
	
	private Map<String, String> requestMap;
	
	private int createTime;
	
	private String openId;
	
	protected Event(EventMessage eventMessage) {
		setRequestMap(eventMessage.getRequestMap());
		setCreateTime(eventMessage.getCreateTime());
		setOpenId(eventMessage.getOpenId());
	}
	
	/**
	 * 处理事件
	 * @return
	 */
	public abstract String process();

	public static Event create(EventMessage eventMessage) {
		String eventType = eventMessage.getEventType();
		
		switch (eventType) {
		case "subscribe":
			return new SubscribeEvent(eventMessage);
		case "unsubscribe":
			return new UnsubscribeEvent(eventMessage);
		default:
			throw new WechatException("unhandled event type:" + eventType);
		}
	}

	public Map<String, String> getRequestMap() {
		return requestMap;
	}

	public void setRequestMap(Map<String, String> requestMap) {
		this.requestMap = requestMap;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	} 
	
}
