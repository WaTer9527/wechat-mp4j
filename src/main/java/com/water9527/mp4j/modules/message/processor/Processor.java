package com.water9527.mp4j.modules.message.processor;

import com.water9527.mp4j.modules.message.Message;

public interface Processor {

	void execute(Message message);
	
	default boolean isNull() {
		return false;
	}
	
}
