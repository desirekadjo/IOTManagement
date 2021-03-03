package com.iot.iotdemo.shared;

import java.util.Arrays;

public enum AccessEnum {

	UNKNOWN("unknown"), GRANTED(200, "granted", true), DENIED(401, "denied", false), OK(200, "ok", true);

	private final String status;
	private final int statusCode;
	private final boolean isAccessGranted;

	AccessEnum(final int statusCode, final String status) {
		this.status = status;
		this.statusCode = statusCode;
		this.isAccessGranted = false;
	}

	AccessEnum(final int statusCode, final String status, final boolean isAccessGranted) {
		this.status = status;
		this.statusCode = statusCode;
		this.isAccessGranted = isAccessGranted;
	}

	AccessEnum(final String status) {
		this.status = status.toUpperCase();
		this.statusCode = 500;
		this.isAccessGranted = false;
	}

	public static AccessEnum getAccessByStatus(final String status) {
		if (status == null || status.length() == 0) {
			return AccessEnum.UNKNOWN;
		}
		return Arrays.stream(values()).filter(access -> access.status.equals(status)).findFirst().orElse(UNKNOWN);
	}

	public String getAccessStatus() {
		return status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public boolean isAccessGranted() {
		return isAccessGranted;
	}

}
