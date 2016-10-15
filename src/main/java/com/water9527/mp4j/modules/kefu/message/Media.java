/**
 * @File : Image.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月17日
 * @Version : V1.0
 */
package com.water9527.mp4j.modules.kefu.message;

import com.alibaba.fastjson.annotation.JSONField;

public class Media {

	@JSONField(name = "media_id")
	private String mediaId;
	
	public Media() {
	}
	
	public Media(String mediaId) {
		setMediaId(mediaId);
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
}
