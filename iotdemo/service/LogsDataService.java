package com.iot.iotdemo.service;

import org.springframework.stereotype.Service;

import com.iot.iotdemo.model.EventRequest;
import com.iot.iotdemo.model.HeartBeatRequest;
import com.iot.iotdemo.model.LogsData;
import com.iot.iotdemo.repository.LogsDataRepository;
import com.iot.iotdemo.shared.Level;
import com.iot.iotdemo.shared.Log;

@Service
public class LogsDataService {

	private final LogsDataRepository logsDataRepository;
	private static int countLog = 1;

	public LogsDataService(final LogsDataRepository logsDataRepository) {
		this.logsDataRepository = logsDataRepository;
	}

	public void writeEventToLog(EventRequest event) {

		if (countLog % 10 == 0) {

			Log.log(Level.ERROR, getClass().getSimpleName(), "simulation of  Failure to write events to table");
		} else {

			LogsData log = new LogsData(event.getPayload().getEmployeeId(),
					event.getPayload().getDoorId(), event.getEvent(), event.getTime(), event.getDeviceId());
			logsDataRepository.save(log);
		}
		countLog++;
	}
	
	public void writeHeartbeatToLog(HeartBeatRequest event) {

		if (countLog % 10 == 0) {

			Log.log(Level.ERROR, getClass().getSimpleName(), "Failedto write heartbeat");
		} else {
			Log.log(Level.INFO, getClass().getSimpleName(), 
					String.format("Heartbeat received from Device %s", event.getDeviceId()));
		}
		countLog++;
	}

}
