/**
 * @File : NullProcessor.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月2日
 * @Version : V1.0
 * @Copyright : 幸福时代网络科技（北京）股份有限公司
 */
package com.water9527.mp4j.modules.message.processor;

import com.water9527.mp4j.base.WechatException;
import com.water9527.mp4j.modules.message.Message;

public class NullProcessor implements Processor {

	@Override
	public void execute(Message message) {
		throw new WechatException("there is no defined processor.");
	}
	
	@Override
	public boolean isNull() {
		return true;
	}

}
