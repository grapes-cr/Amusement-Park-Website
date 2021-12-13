package com.csun.RobotDevTeamWorld.sql.construction;

import com.csun.RobotDevTeamWorld.sql.construction.condition.ConditionBuilder;

public class SelectBuilder extends SQLBuilder {

	private String table;
	private String[] columns;
	private ConditionBuilder condition;
	
	public SelectBuilder(String table) {
		this.table = SQLUtil.sanitize(table);
	}
	
	@Override
	public boolean isValid() {
		return !table.equals("");
	}

	@Override
	public String toString() {
		String tmp = "";
		if(columns==null || columns.length==0)
			tmp = "*";
		else
			for(int i=0;i<this.columns.length;i++)
				tmp += this.columns[i]+(i<this.columns.length-1?", ":"");
		return !isValid()?null : "SELECT "+ tmp +" FROM "+table+ (condition==null?"":this.condition.toString()) +";";
	}
	
	public SelectBuilder setColumns(String... columns) {
		this.columns = new String[columns.length];
		for(int i=0;i<columns.length;i++) {
			String tmp = SQLUtil.sanitize(columns[i]);
			this.columns[i] = tmp;
		}
		return this;
	}
	
	public SelectBuilder setCondition(ConditionBuilder condition) {
		this.condition = condition;
		return this;
	}
	
}