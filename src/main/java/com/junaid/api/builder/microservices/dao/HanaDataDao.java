/**
 * 
 */
package com.junaid.api.builder.microservices.dao;

import java.util.List;

import com.junaid.api.builder.model.db.Row;
import com.junaid.api.builder.querymapper.query.bean.DatabaseConnection;
import com.junaid.api.builder.querymapper.query.bean.QueryOutPut;

/**
 * @author juansari
 *
 */
public interface HanaDataDao {
	public List<Row> getReportData(List<QueryOutPut> queryMap,String userId, DatabaseConnection databaseConnection) throws Exception;
}
