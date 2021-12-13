package com.csun.RobotDevTeamWorld.sql.construction;

public class InsertBuilder extends SQLBuilder {
	
	private String table;
	private String[] cols;
	
	protected InsertBuilder(String table) {
		this.table = SQLUtil.sanitize(table);
	}
	
	public InsertBuilder colNames(String... cols) {
		this.cols = new String[cols.length];
		for(int i=0;i<cols.length;i++)
			this.cols[i] = SQLUtil.sanitize(cols[i]);
		return this;
	}

	@Override
	public boolean isValid() {
		return !table.equals("")&&cols!=null&&cols.length!=0;
	}

	@Override
	public String toString() {
		String tmp = "( ";
		for(int i=0;i<this.cols.length;i++)
			tmp += this.cols[i] + (i<this.cols.length-1?", ":" )");
		tmp += " VALUES ( ";
		for(int i=0;i<this.cols.length;i++)
			tmp += "?" + (i<this.cols.length-1?", ":" )");
		System.out.println(isValid());
		return !isValid()?null: "INSERT INTO "+this.table+tmp;
	}
	
}
