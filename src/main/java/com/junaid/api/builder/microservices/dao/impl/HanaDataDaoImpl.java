/**
 * 
 */
package com.junaid.api.builder.microservices.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.junaid.api.builder.microservices.dao.HanaBaseDao;
import com.junaid.api.builder.microservices.dao.HanaDataDao;
import com.junaid.api.builder.microservices.dao.jdbc.HanaReportResultExtractor;
import com.junaid.api.builder.model.db.Row;
import com.junaid.api.builder.querymapper.query.bean.DatabaseConnection;
import com.junaid.api.builder.querymapper.query.bean.QueryOutPut;
import com.junaid.api.builder.util.DataSourceUtils;
import com.junaid.api.builder.util.QueryProperties;

/**
 * @author juansari
 *
 */
@Repository
public class HanaDataDaoImpl extends HanaBaseDao implements HanaDataDao {

	@Override
	public List<Row> getReportData(List<QueryOutPut> queryMap, String userId, DatabaseConnection databaseConnection)
			throws Exception {
		return this.executeQuery(queryMap, userId, databaseConnection);
	}

	private List<Row> executeQuery(List<QueryOutPut> queryMap, String userId, DatabaseConnection databaseConnection)
			throws Exception {
		List<Row> result = null;
		try {
			// get query, need to change this for multiple queries.for now assumption is
			// that it will have only one query
			QueryOutPut queryOutPut = queryMap.get(0);
			String queryString = queryOutPut.getQuery();
			String isSetSession = queryOutPut.getIsSecured();
			JdbcTemplate localJdbcTemplate = DataSourceUtils.getJdbcTemplate(databaseConnection);
			/*if ("yes".equalsIgnoreCase(isSetSession)) {
				localJdbcTemplate.execute(String.format(QueryProperties.SET_SESSION_USER, userId));
			}*/
			logger.info("Query to execute: {}", queryString);
			long timeTaken = System.currentTimeMillis();
			result = (List<Row>) localJdbcTemplate.query(queryString, new HanaReportResultExtractor());
			logger.info("Time Consumed in Query: {}", (System.currentTimeMillis() - timeTaken));
		} catch (Exception e) {
			logger.error("Exception caught while querying report data : ", e);
			throw new Exception(e.getMessage(), e);
		}
		return result;
	}

}
