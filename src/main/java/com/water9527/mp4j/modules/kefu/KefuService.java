/**
 * @File : KefuService.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月17日
 * @Version : V1.0
 */
package com.water9527.mp4j.modules.kefu;

import com.alibaba.fastjson.JSON;
import com.water9527.mp4j.base.AccessToken;
import com.water9527.mp4j.base.AccessTokenHolder;
import com.water9527.mp4j.base.WechatResult;
import com.water9527.mp4j.modules.kefu.message.CustomMessage;
import com.water9527.mp4j.util.HttpUtils;
import com.water9527.mp4j.util.WechatConstants;

public class KefuService {

	public WechatResult sendMessage(CustomMessage message) {
		String messageStr = JSON.toJSONString(message);
		
		AccessToken accessToken = AccessTokenHolder.getAccessToken();
		String url = WechatConstants.API_SEND_CUSTOM_MESSAGE.replace("ACCESS_TOKEN", accessToken.getToken());
		String entity = HttpUtils.httpPost(url, messageStr);
		
		return JSON.parseObject(entity, WechatResult.class);
	}
	
}
