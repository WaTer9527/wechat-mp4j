package com.water9527.mp4j.modules.message;

import com.alibaba.fastjson.annotation.JSONField;

public class TemplateMessage {

	@JSONField(name = "touser")
	private String toUser;
	
	@JSONField(name = "template_id")
	private String templateId;
	
	@JSONField(name = "topcolor")
	private String topColor;
	
	protected TemplateMessageData data;

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTopColor() {
		return topColor;
	}

	public void setTopColor(String topColor) {
		this.topColor = topColor;
	}

	public TemplateMessageData getData() {
		return data;
	}

	public void setData(TemplateMessageData data) {
		this.data = data;
	}
	
}
