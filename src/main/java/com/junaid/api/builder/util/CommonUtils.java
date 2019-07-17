/**
 * 
 */
package com.junaid.api.builder.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.junaid.api.builder.querymapper.query.bean.ReportConfigDatabase;

/**
 * @author juansari
 *
 */
@Component
public class CommonUtils {
	protected static Logger logger=LoggerFactory.getLogger(CommonUtils.class);
	
	protected static final Pattern p = Pattern.compile("\\?");
    public static final String SINGLE_QUOTE = "'";
    public static String EMPTY_STRING="";

    public static String replaceParameters(String query, Object[] params) {
        StringBuffer sb = new StringBuffer();
        Matcher m = p.matcher(query);
        int i=0;

        while(m.find()) {
            m.appendReplacement(sb, SINGLE_QUOTE + (String) params[i++] + SINGLE_QUOTE);
        }
        m.appendTail(sb);
        return sb.toString();
    }
    
    public static List<String> getStringtoList(String input){    	
    	if(input!=null && input.length()>0) {
    		return Arrays.asList(input.split(","));
    	}
    	return new ArrayList<>();
    }
    
    public static List<ReportConfigDatabase> getObjectFromJson(String jsonObject) {
    	ObjectMapper mapper = new ObjectMapper();
    	List<ReportConfigDatabase> listConfig=null;
    	if(jsonObject!=null) {
    		try {
    			listConfig=mapper.readValue(jsonObject, new TypeReference<List<ReportConfigDatabase>>(){});
			} catch (Exception e) {
				logger.error("Error while converting json to Object", e);
			}
    	}
    	return listConfig;
    }
    public static <T> String convertObjecttoJsonString(Collection<T> input) {
		if(input!=null) {
			Gson gson=new Gson();
			return gson.toJson(input);
		}else {
			return EMPTY_STRING;
		}
	}
    public static String getEndPointUrl(String url) {    	
    	if(url!=null && url.length()>0) {
    		String uri[]=url.split("builder");    		
    			return uri[1];
    		}
		return EMPTY_STRING;
	}
    public static String convertListToCommaString(List<String> input) {    	
    	if(isNullOrEmpty(input)) {
    		return Constants.STRING_EMPTY;
    	}
    	return StringUtils.join(input,Constants.COMMA);
	}
    
    public static <T>boolean isNullOrEmpty(Collection<T> input) {
    	return (input.isEmpty());
	}
    
    public static String convertToCamelString(String input) {
		StringBuilder result = new StringBuilder();
		boolean toUpper = false;
		String newInput=input.toLowerCase();
		for (int i = 0; i < newInput.length(); i++) {
			char c = newInput.charAt(i);
			if (c == Constants.UNDERSCORE_CHAR) {
				toUpper = true;
			} else {
				result.append(toUpper ? Character.toUpperCase(c) : c);
				toUpper = false;
			}
		}
		return result.toString();
	}
    
    public static boolean isNullOrEmpty(String input) {
    	return (StringUtils.isEmpty(input));
	}
}
