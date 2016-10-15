/**
 * @File : VideoCustomMessage.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月17日
 * @Version : V1.0
 */
package com.water9527.mp4j.modules.kefu.message;

public class VideoCustomMessage extends CustomMessage {
	
	public static final String MSG_TYPE = "video"; 

	private Video video;
	
	public VideoCustomMessage() {
	}
	
	public VideoCustomMessage(String openId, String mediaId, String title, String description) {
		super(openId, MSG_TYPE);
		setVideo(new Video(mediaId, title, description));
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
}
