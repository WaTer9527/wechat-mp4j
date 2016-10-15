/**
 * @File : Menu.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月10日
 * @Version : V1.0
 * @Copyright : 幸福时代网络科技（北京）股份有限公司
 */
package com.water9527.mp4j.modules.menu;

public class Menu {

	private Button[] button;
	
	private long menuId;

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}
	
}
