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
		assertNotNull(Config.getInstance());
		assertNotNull(Config.getInstance().getAppId());
		assertNotNull(Config.getInstance().getAppUrl());
		assertNotNull(Config.getInstance().getAppSecret());
		assertNotNull(Config.getInstance().getToken());
	}

}
