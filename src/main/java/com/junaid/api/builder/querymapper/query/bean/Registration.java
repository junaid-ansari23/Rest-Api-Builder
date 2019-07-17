
package com.junaid.api.builder.querymapper.query.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Registration {

    private String apiName;
    @Id
    private String endPoint;
    private String database;
    private String databaseName;
    private String requesterApp;
    private List<ReportConfigDatabase> reportConfig = null;
    private List<String> readUsers = null;
    private List<String> adminUsers = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private int version;

    public String getReportName() {
        return apiName;
    }

    public void setReportName(String reportName) {
        this.apiName = reportName;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    /**
	 * @return the database
	 */
	public String getDatabase() {
		return database;
	}

	/**
	 * @param database the database to set
	 */
	public void setDatabase(String database) {
		this.database = database;
	}

	/**
	 * @return the databaseName
	 */
	public String getDatabaseName() {
		return databaseName;
	}

	/**
	 * @param databaseName the databaseName to set
	 */
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	
	/**
	 * @return the requesterApp
	 */
	public String getRequesterApp() {
		return requesterApp;
	}

	/**
	 * @param requesterApp the requesterApp to set
	 */
	public void setRequesterApp(String requesterApp) {
		this.requesterApp = requesterApp;
	}

	public List<ReportConfigDatabase> getReportConfig() {
        return reportConfig;
    }

    public void setReportConfig(List<ReportConfigDatabase> reportConfig) {
        this.reportConfig = reportConfig;
    }

    public List<String> getUserRole() {
        return readUsers;
    }

    public void setUserRole(List<String> userRole) {
        this.readUsers = userRole;
    }

    public List<String> getAdamGroup() {
        return adminUsers;
    }

    public void setAdamGroup(List<String> adamGroup) {
        this.adminUsers = adamGroup;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
    /**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

}
