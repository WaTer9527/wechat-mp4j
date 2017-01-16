package com.water9527.mp4j.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignatureUtils {

	private static Logger logger = LoggerFactory.getLogger(SignatureUtils.class);

	/**
	 * 除去数组中的空值和签名参数
	 * 
	 * @param sArray
	 *            签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
	public static Map<String, String> paraFilter(Map<String, String> sArray) {

		Map<String, String> result = new HashMap<String, String>();

		if (sArray == null || sArray.size() <= 0) {
			return result;
		}

		for (String key : sArray.keySet()) {
			String value = sArray.get(key);
			if (value == null || value.equals("") || key.equalsIgnoreCase("sign")) {
				continue;
			}

			logger.info("【signature】参与签名的参数：" + key + "=" + value);
			result.put(key, value);
		}

		return result;
	}
	
	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, String> params) {

		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);

			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr;
	}

	/**
	 * 把数组的value排序，并拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String sortParams(Map<String, String> params) {

		List<String> values = new ArrayList<String>(params.values());
		Collections.sort(values);

		String prestr = "";

		for (int i = 0; i < values.size(); i++) {
			String value = values.get(i);

			prestr = prestr + value;
		}

		return prestr;
	}

	/**
	 * SHA1签名字符串
	 * 
	 * @param text
	 *            需要签名的字符串
	 * @param input_charset
	 *            编码格式
	 * @return 签名结果
	 */
	public static String signWithSHA1(String text, String input_charset) {
		return DigestUtils.sha1Hex(getContentBytes(text, input_charset));
	}

	/**
	 * SHA1签名字符串
	 * 
	 * @param text
	 *            需要签名的字符串
	 * @return
	 */
	public static String signWithSHA1(String text) {
		return signWithSHA1(text, "UTF-8");
	}
	
	/**
	 * MD5签名字符串
	 * 
	 * @param text
	 *            需要签名的字符串
	 * @param input_charset
	 *            编码格式
	 * @return 签名结果
	 */
	public static String signWithMD5(String text, String input_charset) {
		return DigestUtils.md5Hex(getContentBytes(text, input_charset));
	}

	/**
	 * MD5签名字符串
	 * 
	 * @param text
	 *            需要签名的字符串
	 * @return
	 */
	public static String signWithMD5(String text) {
		return signWithMD5(text, "UTF-8");
	}

	/**
	 * 签名字符串
	 * 
	 * @param text
	 *            需要签名的字符串
	 * @param sign
	 *            签名结果
	 * @param input_charset
	 *            编码格式
	 * @return 签名结果
	 */
	public static boolean verify(String text, String sign, String input_charset) {
		String mysign = DigestUtils.sha1Hex(getContentBytes(text, input_charset));
		if (mysign.equals(sign)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 签名字符串
	 * 
	 * @param text
	 *            需要签名的字符串
	 * @param sign
	 *            签名结果
	 * @return 签名结果
	 */
	public static boolean verify(String text, String sign) {
		return verify(text, sign, "UTF-8");
	}

	/**
	 * @param content
	 * @param charset
	 * @return
	 * @throws SignatureException
	 * @throws UnsupportedEncodingException
	 */
	private static byte[] getContentBytes(String content, String charset) {
		if (charset == null || "".equals(charset)) {
			return content.getBytes();
		}
		try {
			return content.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("SHA1签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
		}
	}

	/**
	 * 获取当前时间戳
	 * 
	 * @return
	 */
	public static long getTimestamp() {
		return System.currentTimeMillis() / 1000;
	}

	/**
	 * 获取指定长度大小的随机正整数
	 * 
	 * @param length
	 * @return
	 */
	public static String getNonceStr(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1)
			random = random + 0.1;
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}

		return String.valueOf((int) (random * num));
	}

	/**
	 * 用SHA1算法生成安全签名
	 * 
	 * @param token
	 *            票据
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机字符串
	 * @param encrypt
	 *            密文
	 * @return 安全签名
	 * @throws NoSuchAlgorithmException
	 */
	public static String getSHA1(String token, String timestamp, String nonce) throws NoSuchAlgorithmException {
		String[] array = new String[] { token, timestamp, nonce };
		StringBuffer sb = new StringBuffer();
		// 字符串排序
		Arrays.sort(array);
		for (int i = 0; i < 3; i++) {
			sb.append(array[i]);
		}
		String str = sb.toString();
		// SHA1签名生成
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(str.getBytes());
		byte[] digest = md.digest();

		StringBuffer hexstr = new StringBuffer();
		String shaHex = "";
		for (int i = 0; i < digest.length; i++) {
			shaHex = Integer.toHexString(digest[i] & 0xFF);
			if (shaHex.length() < 2) {
				hexstr.append(0);
			}
			hexstr.append(shaHex);
		}
		return hexstr.toString();
	}

}
