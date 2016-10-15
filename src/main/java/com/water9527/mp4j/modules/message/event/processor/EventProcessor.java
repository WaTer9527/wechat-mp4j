/**
 * @File : EventProcessor.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月2日
 * @Version : V1.0
 * @Copyright : 幸福时代网络科技（北京）股份有限公司
 */
package com.water9527.mp4j.modules.message.event.processor;

import com.water9527.mp4j.modules.message.event.Event;

public interface EventProcessor {
	
	void execute(Event event);
	
	default boolean isNull() {
		return false;
	}
}
