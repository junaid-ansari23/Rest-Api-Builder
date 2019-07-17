/**
 * 
 */
package com.junaid.api.builder.model.db;

/**
 * @author juansari
 *
 */
public class DataSet {
	
	private Row rows;
	private String error;
	private String status;

	/**
	 * @return the rows
	 */
	public Row getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(Row rows) {
		this.rows = rows;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}	
}
