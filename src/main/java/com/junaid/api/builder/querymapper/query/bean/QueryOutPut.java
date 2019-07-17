package com.junaid.api.builder.querymapper.query.bean;

public class QueryOutPut {
	
	private String query;
	private String tableName;
	private String dataSourceName;
	private String isSecured;
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getDataSourceName() {
		return dataSourceName;
	}
	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}
	/**
	 * @return the isSecured
	 */
	public String getIsSecured() {
		return isSecured;
	}
	/**
	 * @param isSecured the isSecured to set
	 */
	public void setIsSecured(String isSecured) {
		this.isSecured = isSecured;
	}
	
}
