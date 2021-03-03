package com.iot.iotdemo.repository;

import java.util.List;
import java.util.UUID;

import com.iot.iotdemo.model.LogsData;

public interface LogsDataRepository {
	
	
	public void save(LogsData log);

	public LogsData findById(UUID id);

	public List<LogsData> finbByEmployeeId(int employeeId);

	public List<LogsData> findByDoorId(int doorId);
	
	public void delete(LogsData log);
}
