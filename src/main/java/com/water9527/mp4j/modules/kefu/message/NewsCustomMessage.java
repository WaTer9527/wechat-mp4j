/**
 * @File : NewsCustomMessage.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月17日
 * @Version : V1.0
 */
package com.water9527.mp4j.modules.kefu.message;

import java.util.List;

public class NewsCustomMessage extends CustomMessage {

	public static final String MSG_TYPE = "news";

	private News news;

	public NewsCustomMessage() {
	}

	public NewsCustomMessage(String openId, List<Article> articles) {
		super(openId, MSG_TYPE);
		setNews(new News(articles));
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	
}
