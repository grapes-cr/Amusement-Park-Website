package com.csun.RobotDevTeamWorld.sql.construction.datacarrier;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.csun.RobotDevTeamWorld.sql.SqlController;
import com.csun.RobotDevTeamWorld.sql.construction.SQLBuilder;

public class Ticket extends DataCarrier {
	
	private HashMap<String, Object> members;
	
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
	 * @param from
	 */
	public void populate(SQLBuilder from) {
		SqlController sql = SqlController.Get().open();
		if(sql!=null) {
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
	 * TODO: Post the Contents of this Ticket Object to the SQL DB.
	 * @param to
	 */
	public void post(SQLBuilder to) {
		SqlController sql = SqlController.Get().open();
		
		sql.close();
	}
	
	@Override
	public String toString() {
		return "Ticket{" +
                "id=" + this.getID().intValue() +
                ", Date='" + this.getDate().toString() +
                '}';
	}

}
