/**
 * @File : NullUser.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月9日
 * @Version : V1.0
 * @Copyright : 幸福时代网络科技（北京）股份有限公司
 */
package com.water9527.mp4j.modules.user;

public class NullUser extends User {

	@Override
	public boolean isNull() {
		return true;
	}
	
}
