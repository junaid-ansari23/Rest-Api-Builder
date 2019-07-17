package com.junaid.api.builder.querymapper.query.bean;

import java.util.List;
import java.util.Map;

public class QueryInput {


	private Map<String, String> filter;

	public Map<String, String> getFilter() {
		return filter;
	}

	public void setFilter(Map<String, String> filter) {
		this.filter = filter;
	}


	public List<String> getCoulmnNames() {
		return coulmnNames;
	}

	public void setCoulmnNames(List<String> coulmnNames) {
		this.coulmnNames = coulmnNames;
	}

	public String getDataSourceName() {
		return dataSourceName;
	}

	public List<String> getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(List<String> groupBy) {
		this.groupBy = groupBy;
	}

	public List<String> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(List<String> orderBy) {
		this.orderBy = orderBy;
	}

	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
    public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	private String reportName;
	private List<String> coulmnNames;
	private String dataSourceName;
	private String filterName;
	private List<String> groupBy;
	private List<String> orderBy;

}
