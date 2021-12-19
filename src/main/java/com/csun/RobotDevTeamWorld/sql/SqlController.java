package com.csun.RobotDevTeamWorld.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.logging.Logger;

import com.csun.RobotDevTeamWorld.sql.construction.InsertBuilder;
import com.csun.RobotDevTeamWorld.sql.construction.SelectBuilder;
import com.csun.RobotDevTeamWorld.sql.construction.datacarrier.DataCarrier;
import com.csun.RobotDevTeamWorld.sql.construction.datacarrier.Ticket;

/**
 * A singleton controller class for executing SQL statements
 * @author Brendan Beagin
 *
 */
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
	
	/**
	 * Get an instance of the SqlController
	 * Before sending statements, use {@link SqlController#open()} to open a connection to the SQL server
	 * @return - The SqlController instance
	 */
	public static SqlController Get() {
		if(controller == null || controller.properties == null) {
			controller = new SqlController();
			if(controller == null || controller.properties == null)
				controller = null;
		}
		return controller;
	}
	
	/**
	 * Attempts to open a connection with the SQL Server
	 * @return - The SqlController instance
	 */
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
	
	/**
	 * Attempts to close the connection to the SQL Server
	 * @return - true if successful, false if unsuccessful
	 */
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
	
	/**
	 * Check connection state
	 * @return - true if the connection is open, false otherwise
	 */
	public boolean isOpen() {
		try {
			return connection!=null&&!connection.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Sends query to SQL DataBase
	 * @param from - the query to send
	 * @return
	 */
	public ResultSet executeQuery(SelectBuilder from) {
		try {
			if(connection != null) {
				PreparedStatement queryStatement = connection.prepareStatement(from.toString());
				return queryStatement.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Sends update to SQL DataBase
	 * @param to - The update to send
	 */
	public void executeUpdate(InsertBuilder<? extends DataCarrier> to) {
		try {
			PreparedStatement updateStatement = connection.prepareStatement(to.toString());
			
			DataCarrier data = to.getDataCarrier();
			Iterator<Entry<String,Object>> iter = data.getIter();
			
			int i = 1;
			while(iter.hasNext())
				updateStatement = setIndex(updateStatement, iter.next().getValue(), i++);
			
			updateStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static PreparedStatement setIndex(PreparedStatement statement, Object val, int index) {
		try {
			if(val instanceof Integer)
				statement.setInt(index, (Integer) val);
			else if(val instanceof Date)
				statement.setDate(index, (Date) val);
			else if(val instanceof Double)
				statement.setDouble(index, (Double) val);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}
}