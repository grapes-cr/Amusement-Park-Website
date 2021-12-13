package com.csun.RobotDevTeamWorld.sql.construction.datacarrier;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.csun.RobotDevTeamWorld.sql.SqlController;
import com.csun.RobotDevTeamWorld.sql.construction.SelectBuilder;

public class Ticket extends DataCarrier {
	
	private HashMap<String, Object> members;
	protected static final String[] params = {"Id","Date"};
	
	public Ticket() { }
	
	public Ticket(int id, Date date) {
		super();
		this.setID(id);
		this.setDate(date);
	}
	
	public Integer getID() {
		return this.getValue("Id") instanceof Integer ? (Integer) this.getValue("Id") : null;
	}
	
	public void setID(Integer id) {
		this.addMember("Id", id, true);
	}
	
	public Date getDate() {
		return this.getValue("Date") instanceof Date ? (Date) this.getValue("Date") : null;
	}
	
	public void setDate(Date date) {
		this.addMember("Date", date, true);
	}
	
	/**
	 * Populate this Ticket Object from SQL DB.
	 * @param from - The Query to match
	 */
	public void populate(SelectBuilder from) {
		SqlController sql = SqlController.Get();
		if(sql.open()!=null) {
			try {
				ResultSet resultSet = sql.executeQuery(from);
				if(resultSet.next()) {
					this.setID(resultSet.getInt("Id"));
					this.setDate(resultSet.getDate("Date"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		sql.close();
	}
	
	/**
	 * Retrieve an array of Ticket Objects matching a SQL Query
	 * @param from - The Query to match
	 * @return - Array of Ticket Objects
	 */
	public static Ticket[] matchingList(SelectBuilder from) {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		SqlController sql = SqlController.Get();
		if(sql.open() != null) {
			try {
				ResultSet resultSet = sql.executeQuery(from);
				while(resultSet.next()) {
					Ticket t = new Ticket();
					t.setID(resultSet.getInt("Id"));
					t.setDate(resultSet.getDate("Date"));
					tickets.add(t);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			sql.close();
		}
		
		return tickets==null||tickets.isEmpty()?null : tickets.toArray(new Ticket[0]);
	}
	
	@Override
	public String toString() {
		return "Ticket{" +
                "id=" + this.getID().intValue() +
                ", Date=" + this.getDate().toString() +
                '}';
	}

}
