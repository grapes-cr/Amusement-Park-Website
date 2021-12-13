package com.csun.RobotDevTeamWorld.sql.construction;

/**
 * Entry Point for creation of Sanitized SQL Queries.
 * @author bbeagin
 *
 */
public abstract class SQLBuilder {
	
	public abstract boolean isValid();
	public abstract String toString();
	
	/**
	 * Create SELECT SQL Query
	 * @param table - name of the sql table
	 * @return the Query builder
	 */
	public static SelectBuilder select(String table) {
		table = SQLUtil.sanitize(table);
		return table.equals("")?null: new SelectBuilder(table);
	}
	
	/**
	 * Create SELECT SQL Query
	 * @param table - name of the sql table
	 * @param column - names of selected table columns
	 * @return the Query builder
	 */
	public static SelectBuilder select(String table, String... columns) {
		table = SQLUtil.sanitize(table);
		return table.equals("")?null: new SelectBuilder(table).setColumns(columns);
	}
	
	/**
	 * Create INSERT SQL Query
	 * @param table - name of the sql table
	 * @return the Query builder
	 */
	public static InsertBuilder insert(String table) {
		table = SQLUtil.sanitize(table);
		return table.equals("")?null: new InsertBuilder(table);
	}
	
	/**
	 * Create INSERT SQL Query
	 * @param table - name of the sql table
	 * @param cols - names of columns to fill (ordered)
	 * @return the Query builder
	 */
	public static InsertBuilder insert(String table, String... cols) {
		table = SQLUtil.sanitize(table);
		String[] tmp = new String[cols.length];
		for(int i=0;i<cols.length;i++) {
			tmp[i] = SQLUtil.sanitize(cols[i]);
			if(tmp[i].equals(""))
				tmp[i] = null;
		}
		return table.equals("")?null: new InsertBuilder(table).colNames(cols);
	}
	
}