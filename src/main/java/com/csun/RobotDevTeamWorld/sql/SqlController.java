package com.csun.RobotDevTeamWorld.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import com.csun.RobotDevTeamWorld.sql.construction.InsertBuilder;
import com.csun.RobotDevTeamWorld.sql.construction.SQLBuilder;
import com.csun.RobotDevTeamWorld.sql.construction.SelectBuilder;
import com.csun.RobotDevTeamWorld.sql.construction.datacarrier.Ticket;

public class SqlController {
	
	private static final Logger LOG = Logger.getLogger(SqlController.class.getName());
	
	private static SqlController controller;
	private Properties properties;
	private Connection connection;
	
	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
	}
	
	private SqlController() {
		try {
			properties = new Properties();
			properties.load(SqlController.class.getClassLoader().getResourceAsStream("application.properties"));
		} catch (Exception e) {
			LOG.severe("SQL Properties Missing or improper!!");
			controller = null;
			e.printStackTrace();
		}
	}
	
	public static SqlController Get() {
		if(controller == null || controller.properties == null) {
			controller = new SqlController();
			if(controller == null || controller.properties == null)
				controller = null;
		}
		return controller;
	}
	
	public SqlController open() {
		try {
			if(connection==null||connection.isClosed()) {
				connection = DriverManager.getConnection(properties.getProperty("url"), properties);
				return controller;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.severe("Connection to SQL Sever Unsuccessful!");
		}
		return controller;
	}
	
	public boolean close() {
		try {
			if(connection!=null&&!connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.severe("Failed to close SQL Connection!");
			return false;
		}
		return true;
	}
	
	public ResultSet executeQuery(SQLBuilder builder) {
		if(builder instanceof SelectBuilder)
			try {
				PreparedStatement queryStatement = connection.prepareStatement(builder.toString());
				return queryStatement.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	@Deprecated
	public Integer executeUpdate(SQLBuilder builder) {
		if(builder instanceof InsertBuilder)
			try {
				PreparedStatement updateStatement = connection.prepareStatement(builder.toString());
				return updateStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	@Deprecated
	private Ticket getTicket(SelectBuilder builder) {
		try {
			PreparedStatement readStatement = connection.prepareStatement(builder.toString());
			ResultSet resultSet = readStatement.executeQuery();
			Ticket ticket = null;
			if(resultSet.next()) {
				ticket = new Ticket();
				ticket.setID(resultSet.getInt("ID"));
				ticket.setDate(resultSet.getDate("Date"));
			}
			return ticket;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Deprecated
	private boolean newTicket(InsertBuilder builder, Ticket ticket) {
		try {
			PreparedStatement insertStatement = connection.prepareStatement(builder.toString());
			
			insertStatement.setInt(1, ticket.getID());
			insertStatement.setDate(2, ticket.getDate());
			insertStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}