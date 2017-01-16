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
