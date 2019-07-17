
package com.junaid.api.builder.querymapper.query.bean;

import java.util.List;
import java.util.Map;

public class QueryMapper {

private Map<String, String> filter;
public Map<String, String> getFilter() {
	return filter;
}

public void setFilter(Map<String, String> filter) {
	this.filter = filter;
}

private String reportType;
private List<String> report;
public List<String> getReport() {
	return report;
}

public void setReport(List<String> report) {
	this.report = report;
}

private String databaseView;
private String database;
private List<String> userRole = null;
private List<String> adamGroup = null;
private List<String> applicableColumns = null;

public String getReportType() {
return reportType;
}

public void setReportType(String reportType) {
this.reportType = reportType;
}

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

public List<String> getUserRole() {
return userRole;
}

public void setUserRole(List<String> userRole) {
this.userRole = userRole;
}

public List<String> getAdamGroup() {
return adamGroup;
}

public void setAdamGroup(List<String> adamGroup) {
this.adamGroup = adamGroup;
}

public List<String> getApplicableColumns() {
return applicableColumns;
}

public void setApplicableColumns(List<String> applicableColumns) {
this.applicableColumns = applicableColumns;
}


}