package com.water9527.mp4j.base;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 公众号开发者配置类
 */
public class Config {
	
	private static final Logger logger = LoggerFactory.getLogger(Config.class);
	
	private String appUrl;
	
	private String appId;
	
	private String appSecret;
	
	private String token;
	
	private Config() {}
	
	private static Config instance = new Config();
	
	// 初始化配置文件
	static {
		logger.debug("start init config");
		
		try {
			InputStream in = Config.class.getResourceAsStream("/wechat.properties");
			Properties properties = new Properties();
			properties.load(in);
			
			String appUrl = properties.getProperty("appUrl");
			String appId = properties.getProperty("appId");
			String appSecret = properties.getProperty("appSecret");
			String token = properties.getProperty("token");
			
			instance.setAppId(appId);
			instance.setAppSecret(appSecret);
			instance.setToken(token);
			instance.setAppUrl(appUrl);
			
			if(logger.isDebugEnabled()) {
				logger.debug("appUrl:" + appUrl);
				logger.debug("appId:" + appId);
				logger.debug("appSecret.length:" + appSecret.length());
				logger.debug("token.length:" + token.length());
			}
			
		} catch (Exception e) {
			logger.error("load wechat config file failed", e);
		}
	}
	
	/**
	 * 获取分配给开发者的appId
	 */
	public static String appId() {
		return instance.getAppId();
	}

	/**
	 * 获取分配给开发者的appSecret
	 */
	public static String appSecret() {
		return instance.getAppSecret();
	}

	/**
	 * 获取公众号项目的地址
	 */
	public static String appUrl() {
		return instance.getAppUrl();
	}

	/**
	 * 获取服务器配置的token
	 */
	public static String token() {
		return instance.getToken();
	}
	
	private String getAppUrl() {
		return appUrl;
	}

	private String getAppId() {
		return appId;
	}

	private String getAppSecret() {
		return appSecret;
	}

	private String getToken() {
		return token;
	}

	private void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	private void setAppId(String appId) {
		this.appId = appId;
	}

	private void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	private void setToken(String token) {
		this.token = token;
	}

}
