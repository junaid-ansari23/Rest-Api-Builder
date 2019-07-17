
package com.junaid.api.builder.querymapper.query.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportConfig {

    private String databaseView;
    private String database;
    private List<String> availableColumns = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public List<String> getAvailableColumns() {
        return availableColumns;
    }

    public void setAvailableColumns(List<String> availableColumns) {
        this.availableColumns = availableColumns;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
