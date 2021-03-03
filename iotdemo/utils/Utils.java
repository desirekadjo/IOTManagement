package com.iot.iotdemo.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

//This is a class containing helper functions
public class Utils {

	public static boolean isTimeBadgedAllowAccess(String dateTimeBadged, String fromTime, String toTime) {
		LocalTime timeBadged = null;
		LocalTime fromTimeForDoor = null;
		LocalTime toTimeForDoor = null;
		try {
			timeBadged = LocalDateTime.parse(dateTimeBadged).truncatedTo(ChronoUnit.SECONDS).toLocalTime();
			fromTimeForDoor = LocalTime.parse(fromTime);
			toTimeForDoor = LocalTime.parse(toTime);
		} catch (DateTimeParseException de) {
			throw new IllegalArgumentException("Could not parse the date");

		}

		return ((timeBadged.equals(fromTimeForDoor) || timeBadged.equals(toTimeForDoor))
				|| timeBadged.isAfter(fromTimeForDoor) && timeBadged.isBefore(toTimeForDoor));

	}

	
	public static File readJsonFile(String file) throws IOException {
		File resource = null;
		try {
			resource = new ClassPathResource(file).getFile();
		} catch (FileNotFoundException ex) {
			throw new FileNotFoundException(ex.getMessage());
		}
		return resource;
	}
	
	/**
	 * this method returns a map of users and their corresponding encrypted passwords
	 * Those users are the one stored in our database
	 * They can be used to request a JWT token
	 * user -> password
	 * test1 -> passowrd1
	 * test2 -> password2
	 * test2 -> passowrd3
	 * @return users
	 */
	public static Map<String, String> CreateHardCodedUsersForJWT() {
		final Map<String, String> users = new HashMap<>();
		users.put("test1", "$2a$10$DCk/VH3Klp6mkdxnFPrAqevUQ8zY7rykOfatplvTt9NNEbVCU7aVy");
		users.put("test2", "$2a$10$.eS2/Un1xQWvnzSmrbaFeedPHjcZ.1BjrztG0ye7yv3hoBw9WDP3i");
		users.put("test3", "$2a$10$szUHGgPO3HVcMJ1u6S8ZVOrL/FlrqWxCbxRPLHiLJdchZG25fpeI.");
		return users;
	}
}
