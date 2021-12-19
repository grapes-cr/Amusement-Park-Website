package com.csun.RobotDevTeamWorld.sql.construction;

import com.csun.RobotDevTeamWorld.sql.construction.datacarrier.DataCarrier;

public class InsertBuilder<T extends DataCarrier> extends SQLBuilder {
	
	private String table;
	private T data;
	
	protected InsertBuilder(String table) {
		this.table = SQLUtil.sanitize(table);
	}
	
	/**
	 * Set the Data Carrier used to derive the Insertion Statement
	 * @param data - The DataCarrier to use
	 * @return - this builder
	 */
	public InsertBuilder setDataCarrier(T data) {
		if(data != null)
			this.data = data;
		return this;
	}
	
	/**
	 * Retrieve the DataCarrier used to derive the Insertion Statement
	 * @return - The DaraCarrier
	 */
	public T getDataCarrier() {
		return data;
	}

	@Override
	public boolean isValid() {
		return !table.equals("")&&data!=null&&data.isValid();
	}

	@Override
	public String toString() {
		/*
		String tmp = "( ";
		for(int i=0;i<this.cols.length;i++)
			tmp += this.cols[i] + (i<this.cols.length-1?", ":" )");
		*/
		String tmp = this.data.getParams();
		tmp += " VALUES ( ";
		for(int i=0;i<this.data.size();i++)
			tmp += "?" + (i<this.data.size()-1?", ":" )");
		
		return !isValid()?null: "INSERT INTO "+this.table+tmp;
	}
	
}
