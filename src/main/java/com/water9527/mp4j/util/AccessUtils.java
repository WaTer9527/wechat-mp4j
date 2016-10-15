package com.water9527.mp4j.util;

import static com.water9527.mp4j.util.SignatureUtils.signWithSHA1;
import static com.water9527.mp4j.util.SignatureUtils.sortParams;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.water9527.mp4j.base.Config;
import com.water9527.mp4j.base.WechatException;

/**
 * 微信服务器接入工具类
 */
public class AccessUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(AccessUtils.class);

	/***
	 * 接入验证
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	public static String accessValidator(String signature, String timestamp, String nonce, String echostr)
		throws WechatException {
		
		logger.debug("wechat media plateform access");
		
		if(signature == null || timestamp == null || nonce == null || echostr == null)
			throw new WechatException("invalid parameter number");
		
		String token = Config.getInstance().getToken();
		Map<String, String> paramsMap = new HashMap<>();
		String mySignature;

		paramsMap.put("token", token);
		paramsMap.put("timestamp", timestamp);
		paramsMap.put("nonce", nonce);

		mySignature = signWithSHA1(sortParams(paramsMap));

		logger.debug("recieve sign:" + signature);
		logger.debug("generate sign:" + mySignature);
		if (!mySignature.equals(signature))
			throw new WechatException("wechat media plateform access failed, reason:invalid signature");
		
		logger.info("wechat media plateform access success");
		return echostr;
		
	}
	
}
