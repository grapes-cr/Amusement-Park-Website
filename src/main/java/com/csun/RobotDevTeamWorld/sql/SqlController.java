package com.csun.RobotDevTeamWorld.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import com.csun.RobotDevTeamWorld.sql.packet.Guest;

public class SqlController {
	
	private final Logger LOG = Logger.getLogger(SqlController.class.getName());
	
	private static Properties properties;
	
	private static SqlController controller = new SqlController();
	private static Connection connection;
	
	private SqlController() {
		try {
			properties.load(SqlController.class.getClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			LOG.severe("SQL Properties Missing or improper!!");
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(properties.getProperty("url"), properties);
		} catch (SQLException e) {
			LOG.severe("Connection to SQL Sever Unsuccessful!");
			e.printStackTrace();
		}
	}
	
	public static SqlController Get() {
		if(properties == null || connection == null) {
			controller = new SqlController();
			if(properties == null || connection == null)
				controller = null;
		}
		return controller;
	}
	
	public Guest[] getGuests() throws SQLException {
		LOG.info("Read data");
	    PreparedStatement readStatement = connection.prepareStatement("SELECT * FROM GUESTS;");
	    ResultSet resultSet = readStatement.executeQuery();
	    List<Guest> guestlist = new ArrayList<Guest>();
	    while(resultSet.next()) {
		    Guest guests = new Guest();
		    guests.setId(resultSet.getInt("ID"));
		    guests.setLastName(resultSet.getString("LastName"));
		    guests.setFirstName(resultSet.getString("FirstName"));
		    guests.setAddress(resultSet.getString("Address"));
		    guests.setCity(resultSet.getString("City"));
		    guestlist.add(guests);
	    }
	    if(guestlist.isEmpty())
	    	return null;
	    //for(Guests g : guestlist)
	    	//LOG.info("Data read from the database: " + g.toString());
	    return guestlist.toArray(new Guest[0]);
	}
}
