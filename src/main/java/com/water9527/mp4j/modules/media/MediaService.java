/**
 * @File : MediaService.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月17日
 * @Version : V1.0
 */
package com.water9527.mp4j.modules.media;

import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.water9527.mp4j.base.AccessToken;
import com.water9527.mp4j.base.AccessTokenHolder;
import com.water9527.mp4j.base.WechatException;
import com.water9527.mp4j.util.WechatConstants;

public class MediaService {

	private static final Logger logger = LoggerFactory.getLogger(MediaService.class);

	public static String uploadMedia(String type, byte[] data) throws WechatException {
		logger.info("upload media");

		AccessToken accessToken = AccessTokenHolder.getAccessToken();
		String url = WechatConstants.API_UPLOAD_MEDIA.replace("ACCESS_TOKEN", accessToken.getToken()).replace("TYPE",
				type);

		HttpEntity httpEntity = MultipartEntityBuilder.create()
				.setMode(HttpMultipartMode.BROWSER_COMPATIBLE).setCharset(Consts.UTF_8)
				.addPart("media", new ByteArrayBody(data, ContentType.MULTIPART_FORM_DATA, "media.jpg"))
				.build();
			
		String returnStr;
		try {
			returnStr = Request.Post(url).body(httpEntity)
					.setHeader("Content-Disposition", "form-data")
					.setHeader("name", "media")
					.setHeader("filelength", data.length + "")
					.setHeader("filename", "media.jpg")
					.setHeader("Content-Type", "multipart/form-data")
					.execute().returnContent().asString();
		} catch (IOException e) {
			throw new WechatException(e.getMessage());
		}
		
		logger.debug("returnStr:" + returnStr);
		
		String mediaId = JSON.parseObject(returnStr).getString("media_id");
		
		if(mediaId == null)
			throw new WechatException("missing media id:" + returnStr);
		
		return mediaId;
	}

}
