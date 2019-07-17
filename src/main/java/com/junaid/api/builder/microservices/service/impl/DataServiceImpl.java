/**
 * 
 */
package com.junaid.api.builder.microservices.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junaid.api.builder.microservices.dao.HanaDataDao;
import com.junaid.api.builder.microservices.service.BaseService;
import com.junaid.api.builder.microservices.service.DataService;
import com.junaid.api.builder.model.db.Column;
import com.junaid.api.builder.model.db.Row;
import com.junaid.api.builder.model.request.ReportInput;
import com.junaid.api.builder.querymapper.query.bean.QueryOutPut;
import com.junaid.api.builder.querymapper.query.bean.Registration;
import com.junaid.api.builder.querymapper.query.factory.QuertyFactory;


/**
 * @author juansari
 *
 */
@Service
public class DataServiceImpl extends BaseService implements DataService {

	@Autowired
	private HanaDataDao dataDao;
	
	@Autowired
	private QuertyFactory quertyFactory;

	@Override
	public List<Map<String, Object>> getReportData(ReportInput input,Registration reportDb) throws Exception {
		List<Row> result = null;
		try {
			List<QueryOutPut> queryMap=quertyFactory.buildQuery(input,reportDb);			
			result = dataDao.getReportData(queryMap,input.getUserId(),reportDb.getReportConfig().get(0).getDatabaseConnection());			
			return this.convertResultToJson(result);			
		} catch (Exception e) {
			logger.error("Error while calling dao data method", e);
			throw new Exception("Error while calling dao data method", e);
		}
	}

	private List<Map<String, Object>> convertResultToJson(List<Row> rows) {

		List<Map<String, Object>> output = new ArrayList<>();
		for (Row row : rows) {
			List<Column> columns = row.getColumns();
			Map<String, Object> rowMap = new LinkedHashMap<>();
			// set id
			rowMap.put("Id", row.getId());
			for (Column c : columns) {
				rowMap.put(c.getName(), c.getValue());
			}
			output.add(rowMap);
		}
		return output;
	}

}
