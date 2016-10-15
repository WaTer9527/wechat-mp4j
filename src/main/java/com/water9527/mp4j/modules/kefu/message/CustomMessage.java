/**
 * @File : CustomMessage.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月17日
 * @Version : V1.0
 */
package com.water9527.mp4j.modules.kefu.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.water9527.mp4j.modules.kefu.CustomService;

public abstract class CustomMessage {

	@JSONField(name = "touser")
	private String openId;
	
	@JSONField(name = "msgtype")
	private String msgType;
	
	@JSONField(name = "customservice")
	private CustomService customService;
	
	public CustomMessage() {
	}
	
	public CustomMessage(String openId, String msgType) {
		setOpenId(openId);
		setMsgType(msgType);
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public CustomService getCustomService() {
		return customService;
	}

	public void setCustomService(CustomService customService) {
		this.customService = customService;
	}
	
}
