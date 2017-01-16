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
