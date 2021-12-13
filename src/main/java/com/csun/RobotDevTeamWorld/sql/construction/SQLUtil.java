package com.csun.RobotDevTeamWorld.sql.construction;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class SQLUtil {
	public static String sanitize(String sanitize) {
		sanitize.replaceAll("[^\\w]", "");
		return sanitize;
	}
	
	/**
	 * Pass string in the form yyyy-mm-dd (Ex. 2021-12-12)
	 * @param s - formatted string
	 * @return - sql Date
	 */
	public static Date parseDate(String s) {
		DateTimeFormatter dateFormatter = 
		        new DateTimeFormatterBuilder()
		            .parseCaseInsensitive()
		            .appendPattern("uuuu-MM-dd")
		            .toFormatter(Locale.ENGLISH);
		
		LocalDate date = LocalDate.parse(s, dateFormatter);
		return Date.valueOf(date);
	}
}
