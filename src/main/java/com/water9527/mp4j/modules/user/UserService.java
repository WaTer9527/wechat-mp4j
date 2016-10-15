/**
 * @File : UserService.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月9日
 * @Version : V1.0
 * @Copyright : 幸福时代网络科技（北京）股份有限公司
 */
package com.water9527.mp4j.modules.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.water9527.mp4j.base.AccessToken;
import com.water9527.mp4j.base.AccessTokenHolder;
import com.water9527.mp4j.util.HttpUtils;
import com.water9527.mp4j.util.WechatConstants;

public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	public static User getUserInfo(String openId) {
		User user = new NullUser();

		AccessToken accessToken = AccessTokenHolder.getAccessToken();
		String url = WechatConstants.API_GET_USER_INFO.replace("ACCESS_TOKEN", accessToken.getToken()).replace("OPENID",
				openId);
		String entity = HttpUtils.httpGet(url);
		
		try {
			user = JSON.parseObject(entity, User.class);
		} catch (JSONException e) {
			logger.error("json parse exception:" + e.getMessage() + "entity:" + entity);
		}
		
		if(user.getOpenId() == null)
			return new NullUser();

		return user;
	}

}
