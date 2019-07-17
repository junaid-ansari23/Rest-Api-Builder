package com.junaid.api.builder.microservices.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.junaid.api.builder.querymapper.query.bean.Registration;
import com.junaid.api.builder.util.CommonUtils;

/**
 * 
 * @author juansari
 *
 */
public final class ReportConfigResultExtractor implements ResultSetExtractor<Registration> {

    @Override
    public Registration extractData(ResultSet rs) throws SQLException, DataAccessException {    	    	
    	Registration reportDatabase=new Registration();
    	while (rs.next()) {
    		reportDatabase.setReportName(rs.getString("report_name"));
    		reportDatabase.setEndPoint(rs.getString("end_point"));
    		String reportConfig=rs.getString("report_config");    		
    		reportDatabase.setReportConfig(CommonUtils.getObjectFromJson(reportConfig));
    		reportDatabase.setUserRole(CommonUtils.getStringtoList(rs.getString("user_role")));
    		reportDatabase.setAdamGroup(CommonUtils.getStringtoList(rs.getString("adam_group")));
    	}    	
        return reportDatabase;
    }
   
}
