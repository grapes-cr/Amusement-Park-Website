package com.csun.RobotDevTeamWorld.sql.construction.pattern;

public class BaseBuilder extends PatternBuilder {
	
	private PatternBuilder child;
	
	protected BaseBuilder() {
		super(null);
	}
	
	@Override
	public boolean isValid() {
		return this.child!=null && this.child.isValid();
	}
	
	@Override
	public ContainsBuilder contains() {
		ContainsBuilder tmp = super.contains();
		this.child = tmp;
		return tmp;
	}
	
	@Override
	public TermBuilder term() {
		TermBuilder tmp = super.term();
		this.child = tmp;
		return tmp;
	}
	
	@Override
	public TermBuilder term(String term) {
		TermBuilder tmp = super.term(term);
		this.child = tmp;
		return tmp;
	}
	
	@Override
	public PatternBuilder done() {
		return null;
	}

	@Override
	public String toString() {
		return !isValid()?null:"'"+this.child.toString()+"'";
	}

}
