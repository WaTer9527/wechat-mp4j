package com.water9527.mp4j.modules.message;

public class TemplateMessageDataUnit {

	private String value;
	
	private String color;
	
	public TemplateMessageDataUnit() {}
	
	public TemplateMessageDataUnit(String value) {
		setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
