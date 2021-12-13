package com.csun.RobotDevTeamWorld.sql.construction.condition;

public abstract class ConditionBuilder {
	
	public abstract boolean isValid();
	public abstract String toString();
	
	protected ConditionBuilder() {}
	
	public static EqualsConditionBuilder equals() {
		return new EqualsConditionBuilder();
	}
	
	public static LikeConditionBuilder like() {
		return new LikeConditionBuilder();
	}
	
}
