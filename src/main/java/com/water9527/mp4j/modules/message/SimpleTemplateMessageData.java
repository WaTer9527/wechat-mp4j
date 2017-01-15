package com.water9527.mp4j.modules.message;

public class SimpleTemplateMessageData implements TemplateMessageData {

	private TemplateMessageDataUnit content;
	
	public SimpleTemplateMessageData(String content) {
		setContent(new TemplateMessageDataUnit(content));
	}

	public TemplateMessageDataUnit getContent() {
		return content;
	}

	public void setContent(TemplateMessageDataUnit content) {
		this.content = content;
	}
	
}
