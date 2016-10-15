/**
 * @File : AccessTokenHolderTest.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月19日
 * @Version : V1.0
 */
package com.water9527.mp4j.base;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccessTokenHolderTest {

	@Test
	public void testGetAccessToken() {
		AccessToken accessToken = AccessTokenHolder.getAccessToken();
		assertNotNull(accessToken);
		assertNotNull(accessToken.getToken());
	}

}
