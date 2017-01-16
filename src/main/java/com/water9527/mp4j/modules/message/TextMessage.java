package com.water9527.mp4j.modules.message;

import java.util.Map;

import com.water9527.mp4j.modules.message.processor.NullProcessor;
import com.water9527.mp4j.modules.message.processor.Processor;

public class TextMessage extends Message {
	
	private static Processor processor = new NullProcessor();
	
	public TextMessage(Map<String, String> requestMap) {
		super(requestMap);
	}
	
	public static void registerProcessor(Processor pro) {
		processor = pro;
	}

	@Override
	public String process() {
		processor.execute(this);
		return "";
	}

}
