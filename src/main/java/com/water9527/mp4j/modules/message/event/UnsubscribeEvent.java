/**
 * @File : UnsubscribeEvent.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月9日
 * @Version : V1.0
 * @Copyright : 幸福时代网络科技（北京）股份有限公司
 */
package com.water9527.mp4j.modules.message.event;

import com.water9527.mp4j.modules.message.EventMessage;
import com.water9527.mp4j.modules.message.event.processor.EventProcessor;
import com.water9527.mp4j.modules.message.event.processor.NullEventProcessor;

public class UnsubscribeEvent extends Event {
	
	public static EventProcessor eventProcessor = new NullEventProcessor();

	UnsubscribeEvent(EventMessage eventMessage) {
		super(eventMessage);
	}
	
	@Override
	public String process() {
		eventProcessor.execute(this);
		return "";
	}
	
	public static void registerEventProcessor(EventProcessor pro) {
		eventProcessor = pro;
	}

}
