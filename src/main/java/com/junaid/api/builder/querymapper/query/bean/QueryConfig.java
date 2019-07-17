
package com.junaid.api.builder.querymapper.query.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryConfig {

    private List<Report> report = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Report> getReport() {
        return report;
    }

    public void setReport(List<Report> report) {
        this.report = report;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
}
