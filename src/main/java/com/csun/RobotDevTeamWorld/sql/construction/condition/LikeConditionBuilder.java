package com.csun.RobotDevTeamWorld.sql.construction.condition;

import com.csun.RobotDevTeamWorld.sql.construction.SQLUtil;
import com.csun.RobotDevTeamWorld.sql.construction.pattern.BaseBuilder;

public class LikeConditionBuilder extends ConditionBuilder {
	
	private String column;
	private BaseBuilder pattern;
	
	@Override
	public boolean isValid() {
		return column!=null && this.pattern!=null && this.pattern.isValid();
	}

	@Override
	public String toString() {
		return !isValid()?null: " WHERE "+column+" LIKE "+this.pattern.toString();
	}
	
	public LikeConditionBuilder setColumn(String column) {
		column = SQLUtil.sanitize(column);
		if(!column.equals(""))
			this.column = column;
		return this;
	}
	
	public LikeConditionBuilder setPattern(BaseBuilder pattern) {
		this.pattern = pattern;
		return this;
	}

}
