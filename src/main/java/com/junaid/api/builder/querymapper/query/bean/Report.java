
package com.junaid.api.builder.querymapper.query.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Report {

    private String reportName;
    private String endPoint;
    private List<ReportConfig> reportConfig = null;
    private List<String> userRole = null;
    private List<String> adamGroup = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public List<ReportConfig> getReportConfig() {
        return reportConfig;
    }

    public void setReportConfig(List<ReportConfig> reportConfig) {
        this.reportConfig = reportConfig;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
