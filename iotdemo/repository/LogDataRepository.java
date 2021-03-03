package com.iot.iotdemo.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.iot.iotdemo.model.LogsData;

@Repository
public class LogDataRepository implements LogsDataRepository {

	private Map<UUID, LogsData> repository;

	LogDataRepository() {
		this.repository = new HashMap<>();
	}

	@Override
	public void save(LogsData log) {
		repository.put(log.getLogId(), log);
	}

	@Override
	public LogsData findById(UUID id) {

		return repository.get(id);
	}

	@Override
	public List<LogsData> finbByEmployeeId(int employeeId) {
		return repository.values().stream().filter(log -> log.getEmployeeId() == employeeId)
				.collect(Collectors.toList());
	}

	@Override
	public List<LogsData> findByDoorId(int doorId) {
		return repository.values().stream().filter(log -> log.getDoorId() == doorId).collect(Collectors.toList());
	}

	@Override
	public void delete(LogsData log) {
		repository.remove(log.getLogId());
	}

}
