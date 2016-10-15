/**
 * @File : Video.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月17日
 * @Version : V1.0
 */
package com.water9527.mp4j.modules.kefu.message;

import com.alibaba.fastjson.annotation.JSONField;

public class Video extends Media {

	@JSONField(name = "thumb_media_id")
	private String thumbMediaId;
	
	private String title;
	
	private String description;
	
	public Video() {
	}
	
	public Video(String mediaId, String title, String description) {
		super(mediaId);
		setThumbMediaId(mediaId);
		setTitle(title);
		setDescription(description);
	} 

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
