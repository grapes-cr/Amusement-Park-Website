package com.csun.RobotDevTeamWorld.sql.construction.datacarrier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.csun.RobotDevTeamWorld.sql.SqlController;
import com.csun.RobotDevTeamWorld.sql.construction.InsertBuilder;
import com.csun.RobotDevTeamWorld.sql.construction.SelectBuilder;

public abstract class DataCarrier {
	
	private HashMap<String, Object> members;
	protected static final String[] params = new String[0];
	
	public DataCarrier() {
		this.members = new HashMap<String, Object>();
		for(String s : this.params)
			this.members.put(s, null);
	}
	
	public abstract void populate(SelectBuilder from);
	public abstract String toString();
	
	public Iterator<Entry<String, Object>> getIter() {
		return this.members.entrySet().iterator();
	}
	
	/**
	 * Post the contents of this Calendar Object to the SQL BD based on the InsertBuilder
	 * @param to
	 */
	public void post(InsertBuilder to) {
		to.setDataCarrier(this);
		SqlController sql = SqlController.Get().open();
		if(sql.isOpen()) {
			sql.executeUpdate(to);
			sql.close();
		}
	}
	
	public String getParams() {
		String params = "( ";
		Iterator<Entry<String,Object>> iter = this.members.entrySet().iterator();
		while(iter.hasNext()) 
			params += iter.next().getKey() + (iter.hasNext() ? ", " : " )");
		return params;
	}
	
	public int size() {
		return this.members.size();
	}
	
	public boolean isValid() {
		Iterator<Entry<String,Object>> iter = this.members.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<String, Object> e = iter.next();
			if(e.getKey()==null||e.getKey().equals("")||e.getValue()==null)
				return false;
		}
		return true;
	}
	
	protected boolean addMember(String key, Object value, boolean shouldOverride) {
		if(shouldOverride)
			this.members.put(key, value);
		else
			if(this.members.putIfAbsent(key, value)==null)
				return false;
		return true;
	}
	
	protected Object getValue(String key) {
		if(this.members.containsKey(key))
			return this.members.get(key);
		return null;
	}
	
	protected boolean hasKey(String key) {
		return this.members.containsKey(key);
	}
	
}
