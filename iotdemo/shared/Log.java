package com.iot.iotdemo.shared;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Log {

	private Log() {}

	public static String format(final String serviceId, final String message) {
		return String.format("{appId: %s, serviceId: %s, message: %s}", "IOT_APP", serviceId, message);
	}

	public static void log(final Level level, final String serviceId, final String message) {
		final String messageInfo = format(serviceId, message);

		switch (level) {
		case INFO:
			log.info(messageInfo);
			break;
		case DEBUG:
			log.debug(messageInfo);
			break;
		case WARN:
			log.warn(messageInfo);
			break;
		case ERROR:
			log.error(messageInfo);
			break;
		}
	}

	public static void logWithParams(final Level level, final String serviceId, final String message,
			final Object... params) {
		final String messageInfo = format(serviceId, message);

		switch (level) {
		case INFO:
			log.info(messageInfo, params);
			break;
		case DEBUG:
			log.debug(messageInfo, params);
			break;
		case WARN:
			log.warn(messageInfo, params);
			break;
		case ERROR:
			log.error(messageInfo, params);
			break;
		}
	}
}
