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
	
	/**
	 * Sets the columns to be selected by the SQL Query
	 * If columns are not set "*" will be used (selecting an entire row)
	 * @param columns - Names of the desired columns
	 * @return - this builder
	 */
	public SelectBuilder setColumns(String... columns) {
		this.columns = new String[columns.length];
		for(int i=0;i<columns.length;i++) {
			String tmp = SQLUtil.sanitize(columns[i]);
			this.columns[i] = tmp;
		}
		return this;
	}
	
	/**
	 * Sets the condition used by the SQL Query
	 * @param condition - Condition to apply to the SQL Query
	 * @return - this builder
	 */
	public SelectBuilder setCondition(ConditionBuilder condition) {
		this.condition = condition;
		return this;
	}
	
}