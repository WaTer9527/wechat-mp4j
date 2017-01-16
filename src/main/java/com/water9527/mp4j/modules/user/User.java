package com.water9527.mp4j.modules.user;

import com.alibaba.fastjson.annotation.JSONField;

public class User {

	@JSONField(name = "openid")
	private String openId;
	
	private int subscribe;

	@JSONField(name = "subscribe_time")
	private int subscribeTime;
	
	@JSONField(name = "nickname")
	private String nickName;
	
	private int sex;
	
	private String city;
	
	private String country;
	
	private String province;
	
	private String language;
	
	@JSONField(name = "headimgurl")
	private String headImgUrl;
	
	private String remark;
	
	@JSONField(name = "groupid")
	private String groupId;
	
	public boolean isNull() {
		return false;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public int getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(int subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public int getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(int subscribe) {
		this.subscribe = subscribe;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
}
