/**
 * 
 */
package com.junaid.api.builder.model.db;

import java.util.List;

/**
 * @author juansari
 *
 */
public class Row {
	private long id;
	private List<Column> columns;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the columns
	 */
	public List<Column> getColumns() {
		return columns;
	}
	/**
	 * @param columns the columns to set
	 */
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}	
}
