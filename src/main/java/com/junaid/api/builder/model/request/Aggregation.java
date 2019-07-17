
package com.junaid.api.builder.model.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "function",
    "columns"
})
public class Aggregation {

    @JsonProperty("function")
    private String function;
    @JsonProperty("columns")
    private List<String> columns = null;

    @JsonProperty("function")
    public String getFunction() {
        return function;
    }

    @JsonProperty("function")
    public void setFunction(String function) {
        this.function = function;
    }

    @JsonProperty("columns")
    public List<String> getColumns() {
        return columns;
    }

    @JsonProperty("columns")
    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

}
