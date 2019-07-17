/**
 * 
 */
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
@JsonPropertyOrder({ "name", "value" })
public class Filters {

	@JsonProperty("name")
	private List<String> name = null;
	@JsonProperty("value")
	private List<String> value = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("name")
	public List<String> getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(List<String> name) {
		this.name = name;
	}

	@JsonProperty("value")
	public List<String> getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(List<String> value) {
		this.value = value;
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
