package com.water9527.mp4j.util;

public class WechatConstants {

	/**
	 * 获取access_token地址
	 */
	public static final String API_GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
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
	public static final String API_GET_OAUTH2_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

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
	
}
