package com.water9527.mp4j.util;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {

	private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	public static final int TIMEOUT = 10;

	public static String post(String url) {
		return post(url, "");
	}

	public static String post(String url, String data) {
		return httpPost(url, data);
	}
	
	public static String httpPost(String url, String data, Charset charset) {
		try {
			HttpEntity entity = Request.Post(url).useExpectContinue().version(HttpVersion.HTTP_1_1)
					.bodyString(data, ContentType.create(URLEncodedUtils.CONTENT_TYPE, charset)).execute()
					.returnResponse().getEntity();
			return entity != null ? EntityUtils.toString(entity, charset) : null;
		} catch (Exception e) {
			logger.error("post请求异常，" + e.getMessage() + "\n post url:" + url);
			e.printStackTrace();
		}

		return null;
	}

	public static String httpPost(String url, String data) {
		return httpPost(url, data, Consts.UTF_8);
	}

	public static String post(String url, InputStream inputStream) {
		try {
			HttpEntity entity = Request.Post(url).bodyStream(inputStream, ContentType.create("text/html", Consts.UTF_8))
					.execute().returnResponse().getEntity();
			return entity != null ? EntityUtils.toString(entity, Consts.UTF_8) : null;
		} catch (Exception e) {
			logger.error("post请求异常，" + e.getMessage() + "\n post url:" + url);
			e.printStackTrace();
		}

		return null;
	}

	public static HttpResponse get(String url) {
		try {
			HttpResponse httpResponse = Request.Get(url).execute().returnResponse();
			return httpResponse;
		} catch (Exception e) {
			logger.error("get请求异常，" + e.getMessage() + "\n get url:" + url);
		}
		return null;
	}

	public static String httpGet(String url) {
		try {
			HttpResponse httpResponse = Request.Get(url).execute().returnResponse();
			logger.info("get请求返回码：" + httpResponse.getStatusLine().getStatusCode());
			HttpEntity entity = httpResponse.getEntity();
			return entity != null ? EntityUtils.toString(entity, Consts.UTF_8) : null;
		} catch (Exception e) {
			logger.error("get请求异常，" + e.getMessage() + "\n get url:" + url);
		}
		return null;
	}
	
	public static String getData(Map<String, String> nameValuePairs) {
		String data = "";
		if (nameValuePairs == null) {
			return data;
		}
		for (Map.Entry<String, String> entry : nameValuePairs.entrySet()) {
			data += entry.getKey() + "=" + entry.getValue() + "&";
		}
		return data.substring(0, data.lastIndexOf("&"));
	}
}
