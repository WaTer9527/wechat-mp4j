package com.water9527.mp4j.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.water9527.mp4j.modules.web.Oauth2AccessToken;
import com.water9527.mp4j.util.HttpUtils;
import com.water9527.mp4j.util.WechatConstants;

public class AccessTokenHolder {

	private static final Logger logger = LoggerFactory.getLogger(AccessTokenHolder.class);

	private static AccessToken accessToken;

	static {
		accessToken = new AccessToken();
		requestAccessToken();
	}

	public static AccessToken getAccessToken() {

		if (!isValid(accessToken.getExpiresTime()))
			requestAccessToken();

		return accessToken;
	}

	public static Oauth2AccessToken getOauth2AccessToken(String code) {
		logger.info("request oauth2 accessToken");
		Oauth2AccessToken token = null;

		String url = WechatConstants.API_GET_OAUTH2_ACCESS_TOKEN.replace("APPID", Config.appId())
				.replace("SECRET", Config.appSecret()).replace("CODE", code);
		String entity = HttpUtils.httpGet(url);

		JSONObject jsonObject = JSON.parseObject(entity);

		if (null != jsonObject) {
			String accessToken = jsonObject.getString("access_token");

			if (accessToken == null || "".equals(accessToken))
				logger.info("get oauth2 access_token failed, errcode:" + jsonObject.getIntValue("errcode"));

			token = new Oauth2AccessToken();
			token.setAccessToken(accessToken);
			token.setExpiresIn(jsonObject.getIntValue("expires_in"));
			token.setRefreshToken(jsonObject.getString("refresh_token"));
			token.setOpenId(jsonObject.getString("openid"));
			token.setScope(jsonObject.getString("scope"));
		} else {
			logger.info("jsonObject为null");
		}

		return token;

	}

	/**
	 * token是否有效
	 */
	private static boolean isValid(long expiresTime) {
		return System.currentTimeMillis() <= expiresTime;
	}

	/**
	 * 请求AccessToken
	 */
	private static void requestAccessToken() {
		logger.info("请求AccessToken");

		String url = WechatConstants.API_GET_ACCESS_TOKEN.replace("APPID", Config.appId())
				.replace("APPSECRET", Config.appSecret());
		String entity = HttpUtils.httpGet(url);

		JSONObject jsonObject = JSONObject.parseObject(entity);
		String token = jsonObject.getString("access_token");
		Integer expiresIn = jsonObject.getIntValue("expires_in");

		if (token != null & !("".equals(token))) {
			accessToken.setToken(token);
			accessToken.setExpiresIn(expiresIn);
			accessToken.setExpiresTime((expiresIn - 200) * 1000 + System.currentTimeMillis());

			requestTicket();

			logger.info("请求AccessToken成功");
		} else {
			logger.info("请求AccessToken失败");
		}
	}

	/**
	 * 请求jsapi_ticket
	 */
	private static void requestTicket() {
		logger.info("请求jsapi_ticket");

		String url = WechatConstants.API_GET_TICKET.replace("ACCESS_TOKEN", getAccessToken().getToken());
		String entity = HttpUtils.httpGet(url);

		JSONObject jsonObject = JSONObject.parseObject(entity);
		String errcode = jsonObject.getString("errcode");
		String ticket = jsonObject.getString("ticket");

		if ("0".equals(errcode)) {
			accessToken.setTicket(ticket);

			logger.info("请求jsapi_ticket成功");
		} else {
			logger.info("请求jsapi_ticket失败");
		}
	}

}
