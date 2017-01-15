package com.water9527.mp4j.modules.message;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class TemplateMessageServiceTest {

	@Test
	public void testSendTemplateMessage() {
		TemplateMessage tm = new TemplateMessage();
		tm.setToUser("oWAtaxEDVkfKGzijWNmZ2V0sLCYU");
		tm.setTemplateId("KnUvBUEM9biYVfJHLa7wCqqAKcDaFThj1wgcrly1uvI");
		tm.setData(new SimpleTemplateMessageData("测试内容"));
		System.out.println(JSON.toJSONString(tm));
		Assert.assertTrue(TemplateMessageService.sendTemplateMessage(tm));
	}
	
}
