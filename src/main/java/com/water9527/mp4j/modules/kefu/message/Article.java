/**
 * @File : Article.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月17日
 * @Version : V1.0
 */
package com.water9527.mp4j.modules.kefu.message;

import com.alibaba.fastjson.annotation.JSONField;

public class Article {

	private String title;
	
	private String description;
	
	private String url;
	
	@JSONField(name = "picurl")
	private String picUrl;

	public Article() {
	}

	public Article(String title, String description, String url, String picUrl) {
		this.title = title;
		this.description = description;
		this.url = url;
		this.picUrl = picUrl;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
}
