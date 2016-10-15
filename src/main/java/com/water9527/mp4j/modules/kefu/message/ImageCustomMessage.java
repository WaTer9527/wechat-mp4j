/**
 * @File : ImageCustomMessage.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月17日
 * @Version : V1.0
 */
package com.water9527.mp4j.modules.kefu.message;

public class ImageCustomMessage extends CustomMessage {
	
	public static final String MSG_TYPE = "image"; 

	private Media image;
	
	public ImageCustomMessage() {
	}
	
	public ImageCustomMessage(String openId, String mediaId) {
		super(openId, MSG_TYPE);
		setImage(new Media(mediaId));
	}

	public Media getImage() {
		return image;
	}

	public void setImage(Media image) {
		this.image = image;
	}
	
}
