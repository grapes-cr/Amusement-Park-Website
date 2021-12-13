package com.csun.RobotDevTeamWorld.sql.construction.condition;

import com.csun.RobotDevTeamWorld.sql.construction.SQLUtil;

public class EqualsConditionBuilder extends ConditionBuilder {
	
	private String column;
	private Integer value;
	
	@Override
	public boolean isValid() {
		return column!=null && value!=null;
	}

	@Override
	public String toString() {
		return !isValid()?null: " WHERE "+column+"="+value.intValue();
	}
	
	public EqualsConditionBuilder setColumn(String column) {
		this.column = SQLUtil.sanitize(column);
		if(this.column == "")
			column = null;
		return this;
	}
	
	public EqualsConditionBuilder setValue(int value) {
		this.value = value;
		return this;
	}
	
}
