
package com.junaid.api.builder.model.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "placeholderName",
    "values"
})
public class Placeholder {

    @JsonProperty("placeholderName")
    private String placeholderName;
    @JsonProperty("values")
    private List<String> values = null;

    @JsonProperty("placeholderName")
    public String getPlaceholderName() {
        return placeholderName;
    }

    @JsonProperty("placeholderName")
    public void setPlaceholderName(String placeholderName) {
        this.placeholderName = placeholderName;
    }

    @JsonProperty("values")
    public List<String> getValues() {
        return values;
    }

    @JsonProperty("values")
    public void setValues(List<String> values) {
        this.values = values;
    }

}
