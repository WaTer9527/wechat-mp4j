/**
 * @File : MusicCustomMessage.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月17日
 * @Version : V1.0
 */
package com.water9527.mp4j.modules.kefu.message;

public class MusicCustomMessage extends CustomMessage {

	public static final String MSG_TYPE = "music";
	
	private Music music;

	public MusicCustomMessage(String openId, String title, String description, String musicUrl, String hqMusicUrl, String thumbMediaId) {
		super(openId, MSG_TYPE);
		setMusic(new Music(title, description, musicUrl, hqMusicUrl, thumbMediaId));
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
	
}
