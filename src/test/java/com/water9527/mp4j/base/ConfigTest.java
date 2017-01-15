/**
 * @File : ConfigTest.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月17日
 * @Version : V1.0
 */
package com.water9527.mp4j.base;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConfigTest {

	@Test
	public void testInit() {
		assertNotNull(Config.appId());
		assertNotNull(Config.appUrl());
		assertNotNull(Config.appSecret());
		assertNotNull(Config.token());
	}

}
