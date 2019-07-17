package com.junaid.api.builder.querymapper.query.factory;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.junaid.api.builder.model.request.ReportInput;
import com.junaid.api.builder.querymapper.query.bean.QueryOutPut;
import com.junaid.api.builder.querymapper.query.bean.Registration;
import com.junaid.api.builder.querymapper.query.builder.HanaQueryBuilder;


@Component
public class QuertyFactory{
	protected Logger logger=LoggerFactory.getLogger(QuertyFactory.class);
	
	public List<QueryOutPut> buildQuery(ReportInput input, Registration queryConfig){		
		try {			
			HanaQueryBuilder build = new HanaQueryBuilder();
			build.setRepConfigdb(queryConfig.getReportConfig());
			return build.buildDBQuery(input);
		} catch (Exception e) {
			logger.error("Error while creating query", e);
		}
		return null;
	}

}
