/**
 * @File : Message.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月1日
 * @Version : V1.0
 * @Copyright : 幸福时代网络科技（北京）股份有限公司
 */
package com.water9527.mp4j.modules.message;

import java.util.Map;

import com.water9527.mp4j.base.WechatException;

/**
 * 普通消息和事件消息的抽象类
 */
public abstract class Message {

	private Map<String, String> requestMap;
	
	private int createTime;
	
	protected Message(Map<String, String> requestMap) {
		setRequestMap(requestMap);
		setCreateTime(Integer.valueOf(requestMap.get("CreateTime")));
	}

	/**
	 * 处理接收到的消息
	 */
	public abstract String process();
	
	public static Message create(Map<String, String> requestMap) {
		String msgType = requestMap.get("MsgType");
		
		switch (msgType) {
		case "text":
			return new TextMessage(requestMap);
		case "event":
			return new EventMessage(requestMap);
		default:
			throw new WechatException("unhandled message type:" + msgType);
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
	
}
