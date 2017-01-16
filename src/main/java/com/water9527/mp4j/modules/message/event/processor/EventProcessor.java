package com.water9527.mp4j.modules.message.event.processor;

import com.water9527.mp4j.modules.message.event.Event;

public interface EventProcessor {
	
	void execute(Event event);
	
	default boolean isNull() {
		return false;
	}
}
