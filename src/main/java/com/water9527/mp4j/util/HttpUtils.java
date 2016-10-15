package com.water9527.mp4j.util;

//import java.io.IOException;
import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.Reader;
import java.nio.charset.Charset;
//import java.security.KeyStore;
import java.util.Map;

//import javax.net.ssl.SSLContext;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.fluent.Request;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.ContentType;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.Args;
//import org.apache.http.util.CharArrayBuffer;
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
	
//	public static String doSendMoney(String url, String data) throws Exception {
//		KeyStore keyStore  = KeyStore.getInstance("PKCS12");
//		//加载本地的安全证书
//		InputStream instream = HttpUtil.class.getResourceAsStream("/apiclient_cert.p12");
//        try {
//            keyStore.load(instream, ConfigUtil.getMerchantId().toCharArray());//这里写密码..默认是你的MCHID
//        } catch(Exception e){
//        	logger.info(e.getMessage());
//        	logger.info("MoneyUtils.doSendMoney:keyStore.load;");
//        }finally {
//            instream.close();
//        }
//        // Trust own CA and all self-signed certs
//        SSLContext sslcontext = SSLContexts.custom()
//                .loadKeyMaterial(keyStore, ConfigUtil.getMerchantId().toCharArray())//这里也是写密码的
//                .build();
//        // Allow TLSv1 protocol only
//        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
//        		SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
//        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
//        try {
//        	HttpPost httpost = new HttpPost(url); // 设置响应头信息
//        	httpost.addHeader("Connection", "keep-alive");
//        	httpost.addHeader("Accept", "*/*");
//        	httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//        	httpost.addHeader("Host", "api.mch.weixin.qq.com");
//        	httpost.addHeader("X-Requested-With", "XMLHttpRequest");
//        	httpost.addHeader("Cache-Control", "max-age=0");
//        	httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
//    		httpost.setEntity(new StringEntity(data, "UTF-8"));
//            CloseableHttpResponse response = httpclient.execute(httpost);
//            try {
//                HttpEntity entity = response.getEntity();
//                //微信中必须是以UTF8格式的报文
//                String jsonStr = toStringInfo(response.getEntity(),"UTF-8");
//                //微信返回的报文时GBK，直接使用httpcore解析乱码
//                EntityUtils.consume(entity);
//               return jsonStr;
//            }catch(Exception e){
//            	logger.info(e.getMessage());
//            	logger.info("MoneyUtils.doSendMoney:解析返回报文出错");
//            	return null;
//            } finally {
//                response.close();
//            }
//        }catch(Exception e){
//        	logger.info(e.getMessage());
//        	logger.info("MoneyUtils.doSendMoney:执行http请求出错");
//        	return null;
//        } finally {
//            httpclient.close();
//        }
//	}

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
	
//	private static String toStringInfo(HttpEntity entity, String defaultCharset) throws Exception, IOException{
//		final InputStream instream = entity.getContent();
//	    if (instream == null) {
//	        return null;
//	    }
//	    try {
//	        Args.check(entity.getContentLength() <= Integer.MAX_VALUE,
//	                "HTTP entity too large to be buffered in memory");
//	        int i = (int)entity.getContentLength();
//	        if (i < 0) {
//	            i = 4096;
//	        }
//	        Charset charset = null;
//	        
//	        if (charset == null) {
//	            charset = Charset.forName(defaultCharset);
//	        }
//	        final Reader reader = new InputStreamReader(instream, charset);
//	        final CharArrayBuffer buffer = new CharArrayBuffer(i);
//	        final char[] tmp = new char[1024];
//	        int l;
//	        while((l = reader.read(tmp)) != -1) {
//	            buffer.append(tmp, 0, l);
//	        }
//	        return buffer.toString();
//	    } catch (Exception e){
//	    	logger.info(e.getMessage());
//	    	return null;
//	    }finally {
//	        instream.close();
//	    }
//	}
}
