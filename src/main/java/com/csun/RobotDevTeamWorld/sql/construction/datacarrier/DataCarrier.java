package com.csun.RobotDevTeamWorld.sql.construction.datacarrier;

import java.util.HashMap;

import com.csun.RobotDevTeamWorld.sql.construction.SQLBuilder;

public abstract class DataCarrier {
	
	private HashMap<String, Object> members;
	
	public DataCarrier() {
		this.members = new HashMap<String, Object>();
	}
	
	public abstract String toString();
	public abstract void populate(SQLBuilder builder);
	
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
