/**
 * @File : TextMessage.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月1日
 * @Version : V1.0
 * @Copyright : 幸福时代网络科技（北京）股份有限公司
 */
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
