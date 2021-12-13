package com.csun.RobotDevTeamWorld.sql.construction.pattern;

public abstract class PatternBuilder {
	
	private PatternBuilder parent;
	
	protected PatternBuilder(PatternBuilder parent) {
		this.parent = parent;
	}
	
	public abstract boolean isValid();
	public abstract String toString();
	
	public static BaseBuilder base() {
		return new BaseBuilder();
	}
	
	public PatternBuilder done() {
		PatternBuilder tmp = this.parent;
		while(tmp.parent != null)
			tmp = tmp.parent;
		return tmp;
	}
	
	public ContainsBuilder contains() {
		return new ContainsBuilder(this);
	}
	
	public TermBuilder term() {
		return new TermBuilder(this);
	}
	
	public TermBuilder term(String term) {
		return new TermBuilder(this).setTerm(term);
	}
	
}
