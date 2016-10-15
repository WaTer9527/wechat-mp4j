/**
 * @File : ParentButton.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月10日
 * @Version : V1.0
 * @Copyright : 幸福时代网络科技（北京）股份有限公司
 */
package com.water9527.mp4j.modules.menu;

public class ParentButton extends Button {

	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
	
}
