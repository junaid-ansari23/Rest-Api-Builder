/**
 * 
 */
package com.junaid.api.builder.model.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "orderBy", "direction" })
public class Order {

	@JsonProperty("orderBy")
	private List<String> orderBy;
	@JsonProperty("direction")
	private String direction;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("orderBy")
	public List<String> getOrderBy() {
		return orderBy;
	}

	@JsonProperty("orderBy")
	public void setOrderBy(List<String> orderBy) {
		this.orderBy = orderBy;
	}

	@JsonProperty("direction")
	public String getDirection() {
		return direction;
	}
	@JsonProperty("direction")
	public void setDirection(String direction) {
	this.direction = direction;
	}

}
