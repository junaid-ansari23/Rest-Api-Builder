
package com.junaid.api.builder.querymapper.query.bean;

import java.util.HashMap;
import java.util.Map;

import com.junaid.api.builder.model.db.Column;


public class ReportConfigDatabase {

    private String databaseView;
    private String databaseQuery;
    private String database;
    private String objectType;
    private DatabaseConnection databaseConnection;
    private Map<String,Column> availableColumns = null;
    private Map<String,Column> defaultSelectColumns = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private String isDefaultColumns;
    private Long recordLimit;
    private String isSecured;
    private String queryMode;

    public String getDatabaseView() {
        return databaseView;
    }

    public void setDatabaseView(String databaseView) {
        this.databaseView = databaseView;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
    /**
	 * @return the dataType
	 */
	
	public Map<String,Column> getAvailableColumns() {
        return availableColumns;
    }

    /**
	 * @return the objectType
	 */
	public String getObjectType() {
		return objectType;
	}

	/**
	 * @param objectType the objectType to set
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public void setAvailableColumns(Map<String,Column> availableColumns) {
        this.availableColumns = availableColumns;
    }  	

	/**
	 * @return the isDefaultColumns
	 */
	public String getIsDefaultColumns() {
		return isDefaultColumns;
	}

	/**
	 * @param isDefaultColumns the isDefaultColumns to set
	 */
	public void setIsDefaultColumns(String isDefaultColumns) {
		this.isDefaultColumns = isDefaultColumns;
	}

	/**
	 * @return the defaultSelectColumns
	 */
	public Map<String, Column> getDefaultSelectColumns() {
		return defaultSelectColumns;
	}

	/**
	 * @param defaultSelectColumns the defaultSelectColumns to set
	 */
	public void setDefaultSelectColumns(Map<String, Column> defaultSelectColumns) {
		this.defaultSelectColumns = defaultSelectColumns;
	}

	public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    /**
	 * @return the recordLimit
	 */
	public Long getRecordLimit() {
		return recordLimit;
	}

	/**
	 * @param recordLimit the recordLimit to set
	 */
	public void setRecordLimit(Long recordLimit) {
		this.recordLimit = recordLimit;
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
	
	/**
	 * @return the databaseQuery
	 */
	public String getDatabaseQuery() {
		return databaseQuery;
	}

	/**
	 * @param databaseQuery the databaseQuery to set
	 */
	public void setDatabaseQuery(String databaseQuery) {
		this.databaseQuery = databaseQuery;
	}

	/**
	 * @return the queryMode
	 */
	public String getQueryMode() {
		return queryMode;
	}

	/**
	 * @param queryMode the queryMode to set
	 */
	public void setQueryMode(String queryMode) {
		this.queryMode = queryMode;
	}

	/**
	 * @return the databaseConnection
	 */
	public DatabaseConnection getDatabaseConnection() {
		return databaseConnection;
	}

	/**
	 * @param databaseConnection the databaseConnection to set
	 */
	public void setDatabaseConnection(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}


}
