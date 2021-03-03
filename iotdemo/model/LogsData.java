package com.iot.iotdemo.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.*;

@Data
@NoArgsConstructor
public class LogsData {

	private UUID logId;
	private int EmployeeId;
	private int doorId;
	private String event;
	private String timeBadged;
	private LocalDateTime logDateTime;
	private UUID deviceId;

	public LogsData(int employeeId, int doorId, String event, String timeBadged, UUID deviceId) {
		super();
		this.logId = UUID.randomUUID();
		EmployeeId = employeeId;
		this.doorId = doorId;
		this.event = event;
		this.timeBadged = timeBadged;
		this.logDateTime = LocalDateTime.now();
		this.deviceId = deviceId;
	}

}
