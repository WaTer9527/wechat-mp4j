/**
 * @File : MenuService.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月10日
 * @Version : V1.0
 * @Copyright : 幸福时代网络科技（北京）股份有限公司
 */
package com.water9527.mp4j.modules.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.water9527.mp4j.base.AccessTokenHolder;
import com.water9527.mp4j.util.HttpUtils;
import com.water9527.mp4j.util.WechatConstants;

public class MenuService {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuService.class);

	public static boolean createMenu(Menu menu) {
		
		String accessToken = AccessTokenHolder.getAccessToken().getToken();
		String url = WechatConstants.API_CREATE_MENU.replace("ACCESS_TOKEN", accessToken);
		String jsonMenu = JSON.toJSONString(menu);
		
		logger.debug("create menu:" + jsonMenu);
		
		String entity = HttpUtils.httpPost(url, jsonMenu);
		JSONObject jsonObject = null;
		
		try {
			jsonObject = JSON.parseObject(entity);
		} catch (JSONException e) {
			logger.error("json parse failed, message:" + e.getMessage());
		}
		
		if(jsonObject == null || jsonObject.getIntValue("errcode") != 0) {
			logger.error("create menu failed, return:" + entity);
			return false;
		}
		
		return true;
	}
	
	public static AllMenu getMenu() {
		String accessToken = AccessTokenHolder.getAccessToken().getToken();
		String url = WechatConstants.API_GET_MENU.replace("ACCESS_TOKEN", accessToken);
		
		logger.debug("get menu");
		
		String entity = HttpUtils.httpGet(url);
		AllMenu allMenu = null;
		
		try {
			allMenu = JSON.parseObject(entity, AllMenu.class);
		} catch (JSONException e) {
			logger.error("json parse failed, message:" + e.getMessage());
		}
		
		if(allMenu == null)
			logger.error("get menu failed, return:" + entity);
		
		return allMenu;
	}
	
	public static boolean deleteMenu() {
		String accessToken = AccessTokenHolder.getAccessToken().getToken();
		String url = WechatConstants.API_DELETE_MENU.replace("ACCESS_TOKEN", accessToken);
		
		logger.debug("delete menu");
		
		String entity = HttpUtils.httpGet(url);
		JSONObject jsonObject = null;
		
		try {
			jsonObject = JSON.parseObject(entity);
		} catch (JSONException e) {
			logger.error("json parse failed, message:" + e.getMessage());
		}
		
		if(jsonObject == null || jsonObject.getIntValue("errcode") != 0) {
			logger.error("delete menu failed, return:" + entity);
			return false;
		}
		
		return true;
	}
}
