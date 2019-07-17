package com.junaid.api.builder.model.request;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "offset", "limit" })
public class Pagination {

	@JsonProperty("offset")
	private String offset;
	@JsonProperty("limit")
	private String limit;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("offset")
	public String getOffset() {
		return offset;
	}

	@JsonProperty("offset")
	public void setOffset(String offset) {
		this.offset = offset;
	}

	@JsonProperty("limit")
	public String getLimit() {
		return limit;
	}

	@JsonProperty("limit")
	public void setLimit(String limit) {
		this.limit = limit;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
