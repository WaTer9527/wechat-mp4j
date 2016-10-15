/**
 * @File : Processor.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月1日
 * @Version : V1.0
 * @Copyright : 幸福时代网络科技（北京）股份有限公司
 */
package com.water9527.mp4j.modules.message.processor;

import com.water9527.mp4j.modules.message.Message;

public interface Processor {

	void execute(Message message);
	
	default boolean isNull() {
		return false;
	}
	
}
