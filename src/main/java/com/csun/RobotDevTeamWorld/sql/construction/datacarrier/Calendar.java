package com.csun.RobotDevTeamWorld.sql.construction.datacarrier;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.csun.RobotDevTeamWorld.sql.SqlController;
import com.csun.RobotDevTeamWorld.sql.construction.SelectBuilder;

public class Calendar extends DataCarrier {

	private HashMap<String, Object> members;
	protected static final String[] params = {"Date","OpenHr","CloseHr","Price"};
	
	public Calendar() { }
	
	public Calendar(Date date, int openHr, int closeHr, double price) {
		super();
		this.setDate(date);
		this.setHrs(openHr, closeHr);
		this.setPrice(price);
	}
	
	public Date getDate() {
		return this.getValue("Date") instanceof Date ? (Date) this.getValue("Date") : null;
	}
	
	public void setDate(Date date) {
		this.addMember("Date", date, true);
	}
	
	public Integer[] getHrs() {
		return this.getValue("OpenHr") instanceof Integer && this.getValue("CloseHr") instanceof Integer ? new Integer[] { (Integer) this.getValue("OpenHr"), (Integer) this.getValue("OpenHr") } : null;
	}
	
	public void setHrs(Integer openHr, Integer closeHr) {
		this.addMember("OpenHr", openHr, true);
		this.addMember("CloseHr", closeHr, true);
		
	}
	
	public Double getPrice() {
		return this.getValue("Price") instanceof Double ? (Double) this.getValue("Price") : null;
	}
	
	public void setPrice(Double price) {
		this.addMember("Price", price, true);
	}

	/**
	 * Populate this Calendar Object from SQL DB.
	 * @param from - The Query to match
	 */
	@Override
	public void populate(SelectBuilder from) {
		SqlController sql = SqlController.Get();
		if(sql.open()!=null) {
			try {
				ResultSet resultSet = sql.executeQuery(from);
				if(resultSet.next()) {
					this.setDate(resultSet.getDate("Date"));
					this.setHrs(resultSet.getInt("OpenHr"), resultSet.getInt("CloseHr"));
					this.setPrice(resultSet.getDouble("Price"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		sql.close();
	}
	
	/**
	 * Retrieve an array of Calendar Objects matching a SQL Query
	 * @param from - The Query to match
	 * @return - Array of Calendar Objects
	 */
	public static Calendar[] matchingList(SelectBuilder from) {
		ArrayList<Calendar> calendars = new ArrayList<Calendar>();
		SqlController sql = SqlController.Get();
		if(sql.open() != null) {
			try {
				ResultSet resultSet = sql.executeQuery(from);
				while(resultSet.next()) {
					Calendar c = new Calendar();
					c.setDate(resultSet.getDate("Date"));
					c.setHrs(resultSet.getInt("OpenHr"), resultSet.getInt("CloseHr"));
					c.setPrice(resultSet.getDouble("Price"));
					calendars.add(c);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			sql.close();
		}
		
		return calendars==null||calendars.isEmpty()?null : calendars.toArray(new Calendar[0]);
	}

	@Override
	public String toString() {
		return "Calendar:row{" +
                "Date=" + this.getDate().toString() +
                ", OpenHr=" + (this.getHrs()!=null&&this.getHrs().length==2?this.getHrs()[0].toString() : "NULL") +
                ", CloseHr=" + (this.getHrs()!=null&&this.getHrs().length==2?this.getHrs()[1].toString() : "NULL") +
                ", Price=$" + (this.getPrice()!=null?this.getPrice() : "NULL") +
                '}';
	}
}
