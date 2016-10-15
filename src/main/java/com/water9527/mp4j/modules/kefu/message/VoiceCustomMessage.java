/**
 * @File : VoiceCustomMessage.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月17日
 * @Version : V1.0
 */
package com.water9527.mp4j.modules.kefu.message;

public class VoiceCustomMessage extends CustomMessage {
	
	public static final String MSG_TYPE = "voice"; 

	private Media voice;
	
	public VoiceCustomMessage() {
	}
	
	public VoiceCustomMessage(String openId, String mediaId) {
		super(openId, MSG_TYPE);
		setVoice(new Media(mediaId));
	}

	public Media getVoice() {
		return voice;
	}

	public void setVoice(Media voice) {
		this.voice = voice;
	}
	
}
