package com.csun.RobotDevTeamWorld.sql.construction;

public class SQLUtil {
	public static String sanitize(String sanitize) {
		sanitize.replaceAll("[^\\w]", "");
		return sanitize;
	}
}
