/**
 * @File : DefaultEventMessageProcessor.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月10日
 * @Version : V1.0
 * @Copyright : 幸福时代网络科技（北京）股份有限公司
 */
package com.water9527.mp4j.modules.message.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.water9527.mp4j.modules.message.EventMessage;
import com.water9527.mp4j.modules.message.Message;
import com.water9527.mp4j.modules.message.event.Event;

public class DefaultEventMessageProcessor implements Processor {
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultEventMessageProcessor.class);

	@Override
	public void execute(Message message) {
		logger.info("processor execute");
		EventMessage eventMessage = (EventMessage) message;
		Event event = Event.create(eventMessage);
		
		event.process();
	}

}
