package com.junaid.api.builder.querymapper.query.bean;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigrationYaml {
	   public String getReport() {
		return report;
	}



	public void setReport(String report) {
		this.report = report;
	}



	public String getDataSourceName() {
		return dataSourceName;
	}



	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}



	public String getTableName() {
		return tableName;
	}



	public void setTableName(String tableName) {
		this.tableName = tableName;
	}



	public List<String> getColumns() {
		return columns;
	}



	public void setColumns(List<String> columns) {
		this.columns = columns;
	}



	public String getUserRole() {
		return userRole;
	}



	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}



	private String  report;
	    private String dataSourceName;
	    private String tableName;
	    private List< String > columns;
	    private String userRole;

	    
}
