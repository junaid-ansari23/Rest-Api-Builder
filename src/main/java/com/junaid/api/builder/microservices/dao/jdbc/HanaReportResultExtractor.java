package com.junaid.api.builder.microservices.dao.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.junaid.api.builder.model.db.Column;
import com.junaid.api.builder.model.db.Row;
import com.junaid.api.builder.util.CommonUtils;


/**
 * 
 * @author juansari
 *
 */
public final class HanaReportResultExtractor implements ResultSetExtractor<List<Row>> {

    @Override
    public List<Row> extractData(ResultSet rs) throws SQLException, DataAccessException {
    	List<Row> rows=new ArrayList<>();
    	int seq=1;
    	while (rs.next()) {
    		rs.setFetchSize(1000);
    		ResultSetMetaData rsmd=rs.getMetaData();
    		int colCount=rsmd.getColumnCount();
    		List<Column> columns=new ArrayList<>();
    		for(int index=1;index<=colCount;index++) {
    			String name=rsmd.getColumnName(index);
    			String type=rsmd.getColumnTypeName(index);
    			Object value=rs.getObject(index);
    			Column col=new Column();
    			col.setName(CommonUtils.convertToCamelString(name));
    			col.setType(type);
    			col.setValue(value);
    			columns.add(col);
    		}
    		Row row=new Row();
    		row.setColumns(columns);
    		row.setId(seq++);
    		rows.add(row);
    	}    	
        return rows;
    }
}
