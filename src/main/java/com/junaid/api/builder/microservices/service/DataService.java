/**
 * 
 */
package com.junaid.api.builder.microservices.service;

import java.util.List;
import java.util.Map;

import com.junaid.api.builder.model.request.ReportInput;
import com.junaid.api.builder.querymapper.query.bean.Registration;


/**
 * @author juansari
 *
 */
public interface DataService {
	public List<Map<String, Object>> getReportData(ReportInput input, Registration reportDb) throws Exception;
}
