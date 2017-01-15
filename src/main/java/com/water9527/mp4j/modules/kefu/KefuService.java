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
import com.water9527.mp4j.base.UrlGenerator;
import com.water9527.mp4j.base.WechatResult;
import com.water9527.mp4j.modules.kefu.message.CustomMessage;
import com.water9527.mp4j.util.HttpUtils;

public class KefuService {

	public WechatResult sendMessage(CustomMessage message) {
		String messageStr = JSON.toJSONString(message);
		
		AccessToken accessToken = AccessTokenHolder.getAccessToken();
		String url = UrlGenerator.sendCustomMessage(accessToken.getToken());
		String entity = HttpUtils.httpPost(url, messageStr);
		
		return JSON.parseObject(entity, WechatResult.class);
	}
	
}
