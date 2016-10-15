/**
 * @File : TextCustomMessage.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月17日
 * @Version : V1.0
 */
package com.water9527.mp4j.modules.kefu.message;

public class TextCustomMessage extends CustomMessage {
	
	public static final String MSG_TYPE = "text"; 

	private Text text;
	
	public TextCustomMessage() {
	}

	public TextCustomMessage(String openId, String content) {
		super(openId, MSG_TYPE);
		setText(new Text(content));
	}
	
	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}
	
}