package com.water9527.mp4j.base;

public class UrlGenerator {

	/**
	 * appId占位符
	 */
	public static final String PLACEHOLDER_APP_ID = "APPID";

	/**
	 * appSecret占位符
	 */
	public static final String PLACEHOLDER_APP_SECRET = "APPSECRET";

	/**
	 * accessToken占位符
	 */
	public static final String PLACEHOLDER_ACCESS_TOKEN = "ACCESS_TOKEN";

	/**
	 * openId占位符
	 */
	public static final String PLACEHOLDER_OPEN_ID = "OPENID";

	/**
	 * code占位符
	 */
	public static final String PLACEHOLDER_CODE = "CODE";
	
	/**
	 * type占位符
	 */
	public static final String PLACEHOLDER_TYPE = "TYPE";

	/**
	 * 获取access_token地址
	 */
	public static final String API_GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
			+ Config.appId() + "&secret=" + Config.appSecret();

	/**
	 * 获取jsapi_ticket接口地址
	 */
	public static final String API_GET_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

	/**
	 * 获取userInfo接口地址
	 */
	public static final String API_GET_USER_INFO = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	/**
	 * createMenu接口地址
	 */
	public static final String API_CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	/**
	 * getMenu接口地址
	 */
	public static final String API_GET_MENU = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

	/**
	 * deleteMenu接口地址
	 */
	public static final String API_DELETE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	/**
	 * oauth2接口地址
	 */
	public static final String API_OAUTH2 = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";

	/**
	 * 获取oauth2 accessToken接口地址
	 */
	public static final String API_GET_OAUTH2_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
			+ Config.appId() + "&secret=" + Config.appSecret() + "&code=CODE&grant_type=authorization_code";

	/**
	 * 群发消息接口地址
	 */
	public static final String API_SEND_MASS_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";

	/**
	 * 生成带参数二维码接口地址
	 */
	public static final String API_CREATE_QRCODE = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";

	/**
	 * 素材库列表接口地址
	 */
	public static final String API_BATCH_GET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";

	/**
	 * 新增临时素材接口
	 */
	public static final String API_UPLOAD_MEDIA = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";

	/**
	 * 上传图文消息接口
	 */
	public static final String API_ADD_NEWS = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";

	/**
	 * 上传图片接口
	 */
	public static final String API_UPLOAD_IMG = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";

	/**
	 * 上传其他永久素材接口
	 */
	public static final String API_ADD_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN";

	/**
	 * 发送客服消息接口
	 */
	public static final String API_SEND_CUSTOM_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

	public static String getAccessToken() {
		return API_GET_ACCESS_TOKEN;
	}

	public static String getAuth2AccessToken(String code) {
		return API_GET_OAUTH2_ACCESS_TOKEN.replace(PLACEHOLDER_CODE, code);
	}
	
	public static String getTicket(String accessToken) {
		return API_GET_TICKET.replace(PLACEHOLDER_ACCESS_TOKEN, accessToken);
	}

	public static String sendCustomMessage(String accessToken) {
		return API_SEND_CUSTOM_MESSAGE.replace(PLACEHOLDER_ACCESS_TOKEN, accessToken);
	}
	
	public static String updateMedia(String accessToken, String type) {
		return API_UPLOAD_MEDIA.replace(PLACEHOLDER_ACCESS_TOKEN, accessToken).replace(PLACEHOLDER_TYPE, type);
	}
	
	public static String createMenu(String accessToken) {
		return API_CREATE_MENU.replace(PLACEHOLDER_ACCESS_TOKEN, accessToken);
	}
	
	public static String getMenu(String accessToken) {
		return API_GET_MENU.replace(PLACEHOLDER_ACCESS_TOKEN, accessToken);
	}
	
	public static String deleteMenu(String accessToken) {
		return API_DELETE_MENU.replace(PLACEHOLDER_ACCESS_TOKEN, accessToken);
	}
	
	public static String getUserInfo(String accessToken, String openId) {
		return API_GET_USER_INFO.replace(PLACEHOLDER_ACCESS_TOKEN, accessToken).replace(PLACEHOLDER_OPEN_ID, openId);
	}
}
