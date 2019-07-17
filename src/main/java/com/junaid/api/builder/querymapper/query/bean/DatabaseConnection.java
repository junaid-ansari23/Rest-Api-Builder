package com.junaid.api.builder.querymapper.query.bean;

import com.junaid.api.builder.util.PasswordUtil;

public class DatabaseConnection {

	private String database;
	private String databaseName;
	private String connectionType;
	private String connectionUrl;
	private String user;
	private String password;

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	public String getConnectionUrl() {
		return connectionUrl;
	}

	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password!=null && !password.trim().isEmpty()) {
			this.password = PasswordUtil.encrypt(password);	
		}		
	}

}