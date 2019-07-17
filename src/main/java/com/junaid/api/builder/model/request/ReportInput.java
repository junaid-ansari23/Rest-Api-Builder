package com.junaid.api.builder.model.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requestorApp",
    "userId",
    "columns",
    "placeholders",
    "aggregation",
    "filters",
    "orders",
    "groupBy",
    "paging" })

public class ReportInput {

	@JsonProperty("requestorApp")
	private String requestorApp;
	@JsonProperty("reportName")
	private String reportName;
	@JsonProperty("userId")
	private String userId;
	@JsonProperty("columns")
	private List<String> columns = null;
	@JsonProperty("placeholder")
    private List<Placeholder> placeholders = null;
    @JsonProperty("aggregates")
    private List<Aggregation> aggregation = null;
	@JsonProperty("filters")
	private List<Map<String,List<Object>>> filters;
	@JsonProperty("orders")
	private Order orders = null;
	@JsonProperty("groupBy")
    private List<String> groupBy = null;
	@JsonProperty("paging")
	private Pagination paging;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	@JsonIgnore
	private String endPoint;

	@JsonProperty("requestorApp")
	public String getRequestorApp() {
		return requestorApp;
	}

	@JsonProperty("requestorApp")
	public void setRequestorApp(String requestorApp) {
		this.requestorApp = requestorApp;
	}

	@JsonProperty("reportName")
	public String getReportName() {
		return reportName;
	}

	@JsonProperty("reportName")
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	@JsonProperty("userId")
	public String getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonProperty("columns")
	public List<String> getColumns() {
		return columns;
	}

	@JsonProperty("columns")
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	@JsonProperty("placeholders")
    public List<Placeholder> getPlaceholders() {
        return placeholders;
    }

    @JsonProperty("placeholders")
    public void setPlaceholders(List<Placeholder> placeholders) {
        this.placeholders = placeholders;
    }

    @JsonProperty("aggregation")
    public List<Aggregation> getAggregation() {
        return aggregation;
    }

    @JsonProperty("aggregation")
    public void setAggregates(List<Aggregation> aggregation) {
        this.aggregation = aggregation;
    }

	@JsonProperty("filters")
	public List<Map<String,List<Object>>> getFilters() {
		return filters;
	}

	@JsonProperty("filters")
	public void setFilters(List<Map<String,List<Object>>> filters) {
		this.filters = filters;
	}

	@JsonProperty("orders")
	public Order getOrders() {
		return orders;
	}

	@JsonProperty("orders")
	public void setOrders(Order orders) {
		this.orders = orders;
	}
	@JsonProperty("groupBy")
    public List<String> getGroupBy() {
        return groupBy;
    }

    @JsonProperty("groupBy")
    public void setGroupBy(List<String> groupBy) {
        this.groupBy = groupBy;
    }

	@JsonProperty("paging")
	public Pagination getPaging() {
		return paging;
	}

	@JsonProperty("paging")
	public void setPaging(Pagination paging) {
		this.paging = paging;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	/**
	 * @return the endPoint
	 */
	public String getEndPoint() {
		return endPoint;
	}

	/**
	 * @param endPoint the endPoint to set
	 */
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	
}
