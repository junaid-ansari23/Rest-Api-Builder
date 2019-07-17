/**
 * 
 */
package com.junaid.api.builder.microservices.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author juansari
 *
 */
@Component
public class BaseController {
	protected Logger logger=LoggerFactory.getLogger(BaseController.class);
	static ObjectMapper objectMapper = new ObjectMapper();	
	static {
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}
}
