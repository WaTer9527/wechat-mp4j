/**
 * @File : CustomService.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月17日
 * @Version : V1.0
 */
package com.water9527.mp4j.modules.kefu;

import com.alibaba.fastjson.annotation.JSONField;

public class CustomService {

	@JSONField(name = "kf_account")
	private String kfAccount;
	
	public CustomService() {
	}

	public CustomService(String kfAccount) {
		setKfAccount(kfAccount);
	}
	
	public String getKfAccount() {
		return kfAccount;
	}

	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}
	
}
