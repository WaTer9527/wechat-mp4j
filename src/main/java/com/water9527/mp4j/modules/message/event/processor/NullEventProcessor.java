/**
 * @File : NullEventProcessor.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月9日
 * @Version : V1.0
 * @Copyright : 幸福时代网络科技（北京）股份有限公司
 */
package com.water9527.mp4j.modules.message.event.processor;

import com.water9527.mp4j.base.WechatException;
import com.water9527.mp4j.modules.message.event.Event;

public class NullEventProcessor implements EventProcessor {

	@Override
	public void execute(Event event) {
		throw new WechatException("there is no defined event processor.");
	}
	
	@Override
	public boolean isNull() {
		return true;
	}

}
