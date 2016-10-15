package com.water9527.mp4j.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 微信接入配置类
 */
public class Config {
	
	private static final Logger logger = LoggerFactory.getLogger(Config.class);
	
	private String appUrl;
	
	private String appId;
	
	private String appSecret;
	
	private String token;
	
	private static Config instance;
	
	public synchronized static Config getInstance() {
		if(instance == null)
			instance = new Config();
		return instance;
	}

	public Config() {
		init();
	}
	
	private void init() {
		logger.info("start init config");
		
		try {
			InputStream in = Config.class.getResourceAsStream("/wechatConfig.properties");
			Properties properties = new Properties();
			properties.load(in);
			
			appUrl = properties.getProperty("appUrl");
			appId = properties.getProperty("appId");
			appSecret = properties.getProperty("appSecret");
			token = properties.getProperty("token");
			
			logger.info("appUrl:" + appUrl);
			logger.info("appId:" + appId);
			logger.info("appSecret.length:" + appSecret.length());
			logger.info("token.length:" + token.length());
			
		} catch (IOException e) {
			logger.error("load config file failed, message:" + e.getMessage());
		}
	}

	public String getAppUrl() {
		return appUrl;
	}

	public String getAppId() {
		return appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public String getToken() {
		return token;
	}

}
