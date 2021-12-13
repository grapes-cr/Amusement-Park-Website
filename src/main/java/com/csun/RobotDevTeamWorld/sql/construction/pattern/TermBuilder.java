package com.csun.RobotDevTeamWorld.sql.construction.pattern;

import com.csun.RobotDevTeamWorld.sql.construction.SQLUtil;

public class TermBuilder extends PatternBuilder {
	
	private PatternBuilder parent;
	
	private String term;
	
	protected TermBuilder(PatternBuilder parent) {
		super(parent);
	}
	
	public TermBuilder setTerm(String term) {
		term = SQLUtil.sanitize(term);
		if(!term.equals(""))
			this.term = term;
		return this;
	}
	
	@Override
	public boolean isValid() {
		return term!=null;
	}

	@Override
	public String toString() {
		return term;
	}
	
	
}
