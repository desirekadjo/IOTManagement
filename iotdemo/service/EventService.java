package com.iot.iotdemo.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.iot.iotdemo.model.Door;
import com.iot.iotdemo.model.EventRequest;
import com.iot.iotdemo.model.EventResponse;
import com.iot.iotdemo.shared.AccessEnum;
import com.iot.iotdemo.shared.Level;
import com.iot.iotdemo.shared.Log;
import com.iot.iotdemo.utils.Utils;

@Service
public class EventService {

	private final DoorService doorService;

	private final LogsDataService logsDataService;

	EventService(final DoorService doorService, final LogsDataService logsDataService) {
		this.doorService = doorService;
		this.logsDataService = logsDataService;
	}

	public EventResponse getAccessToDoor(EventRequest eventRequest) {

		final int doorId = eventRequest.getPayload().getDoorId();
		final int employeeId = eventRequest.getPayload().getEmployeeId();

		logsDataService.writeEventToLog(eventRequest);

		Door currentDoor = doorService.getDoorDetailsByDoorId(doorId);

		if (currentDoor != null) {
			if (!hasAccessLevelRequired(eventRequest, currentDoor)) {
				Log.logWithParams(Level.ERROR, getClass().getSimpleName(),
						"Employee {} does not have access to door {}", employeeId, doorId);
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, AccessEnum.DENIED.getAccessStatus());
			}

			if (!isTimeAllowedForDoor(eventRequest, currentDoor)) {
				Log.logWithParams(Level.ERROR, getClass().getSimpleName(),
						"Employee {} cannot access the door {} at this time", employeeId, doorId);
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, AccessEnum.DENIED.getAccessStatus());
			}
		} else {
			Log.logWithParams(Level.ERROR, getClass().getSimpleName(), "Door {} does not exists", doorId);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, AccessEnum.DENIED.getAccessStatus());
		}
		Log.logWithParams(Level.INFO, getClass().getSimpleName(), "Employee {} has access to door {}", employeeId,
				doorId);
		return new EventResponse(AccessEnum.GRANTED.getStatusCode(),AccessEnum.GRANTED.getAccessStatus(),AccessEnum.GRANTED.isAccessGranted());
	}
	

	public boolean hasAccessLevelRequired(EventRequest eventRequest, Door door) {
		return eventRequest.getPayload().getAccessLevel() >= door.getPrivilege().getAccessLevel();
	}

	public boolean isTimeAllowedForDoor(EventRequest eventRequest, Door door) {
		return Utils.isTimeBadgedAllowAccess(eventRequest.getTime(), door.getFromDt(), door.getToDate());
	}
}
