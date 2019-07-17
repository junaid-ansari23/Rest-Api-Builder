package com.junaid.api.builder.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:query.properties")
@Component
public class QueryProperties{

    public static final String SET_SESSION_USER = "SET 'SESSION_USER' = '%s'";
    private static final String WEEK_FILTER_QUERY = "week.filter.query";
    
    @Autowired
    private Environment env;

    public String getWeekFilterQuery() {
        return env.getProperty(WEEK_FILTER_QUERY);
    }
    public String getBookingQuery() {
        return env.getProperty("booking.data.report");
    }

}
