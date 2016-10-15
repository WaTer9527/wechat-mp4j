/**
 * @File : SubscribeEvent.java
 * @Description :
 * 
 * 
 * @author : WaTer
 * @Date : 2016年8月9日
 * @Version : V1.0
 * @Copyright : 幸福时代网络科技（北京）股份有限公司
 */
package com.water9527.mp4j.modules.message.event;

import com.water9527.mp4j.modules.message.EventMessage;
import com.water9527.mp4j.modules.message.event.processor.EventProcessor;
import com.water9527.mp4j.modules.message.event.processor.NullEventProcessor;

public class SubscribeEvent extends Event {

	/**
	 * 默认的eventKey空值
	 */
	public static final int EVENT_KEY_NULL = 0;

	private static EventProcessor eventProcessor = new NullEventProcessor();

	private int eventKey;

	private String ticket;

	SubscribeEvent(EventMessage eventMessage) {
		super(eventMessage);
		setEventKey(computeEventKey());
		setTicket(getRequestMap().get("Ticket"));
	}

	@Override
	public String process() {
		eventProcessor.execute(this);
		return "";
	}

	public static void registerEventProcessor(EventProcessor pro) {
		eventProcessor = pro;
	}

	private int computeEventKey() {
		String strEventKey = getRequestMap().get("EventKey");
		if (strEventKey == null || "".equals(strEventKey))
			return EVENT_KEY_NULL;

		return strEventKey.startsWith("qrscene_") ? Integer.valueOf(strEventKey.replace("qrscene_", ""))
				: Integer.valueOf(strEventKey);
	}

	public int getEventKey() {
		return eventKey;
	}

	public void setEventKey(int eventKey) {
		this.eventKey = eventKey;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

}
