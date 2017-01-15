package com.water9527.mp4j.modules.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.water9527.mp4j.base.AccessTokenHolder;
import com.water9527.mp4j.base.UrlGenerator;
import com.water9527.mp4j.util.HttpUtils;

public class TemplateMessageService {
	
	private static final Logger logger = LoggerFactory.getLogger(TemplateMessageService.class);
	
	public static boolean sendTemplateMessage(TemplateMessage templateMessage) {
		logger.debug("send template message");
		
		String accessToken = AccessTokenHolder.getAccessToken().getToken();
		String entity = HttpUtils.httpPost(UrlGenerator.sendTemplateMessage(accessToken), JSON.toJSONString(templateMessage));
		JSONObject jsonObject = null;
		
		try {
			jsonObject = JSON.parseObject(entity);
		} catch (Exception e) {
			logger.error("send template message failed, json parse failed, entity:" + entity, e);
			return false;
		}
		
		if(jsonObject == null || jsonObject.getIntValue("errcode") != 0) {
			logger.error("send template message failed, return:" + entity);
			return false;
		}
		
		return true;
	}

}
