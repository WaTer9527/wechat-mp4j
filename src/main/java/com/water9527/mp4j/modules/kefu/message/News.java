/**
 * @File : News.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月17日
 * @Version : V1.0
 */
package com.water9527.mp4j.modules.kefu.message;

import java.util.List;

public class News {

	private List<Article> articles;

	public News() {
	}

	public News(List<Article> articles) {
		this.articles = articles;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
}
