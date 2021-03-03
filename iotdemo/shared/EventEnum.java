package com.iot.iotdemo.shared;

import java.util.Arrays;

public enum EventEnum {

	UNKNOWN("unknow"), HEARTBEAT("heartbeat"), ENTER("enter"), EXIT("exit");

	private EventEnum(String event) {
		this.event = event;
	}

	private String event;

	public String getEvent() {
		return event;
	}

	public static EventEnum getEventByName(String event) {
		if (event == null || event.isEmpty()) {
			return UNKNOWN;
		}

		return Arrays.stream(values()).filter(ev -> ev.event.equals(event)).findFirst().orElse(UNKNOWN);
	}

}
