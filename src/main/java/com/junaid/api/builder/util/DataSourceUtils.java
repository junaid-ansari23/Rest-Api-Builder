package com.junaid.api.builder.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.junaid.api.builder.querymapper.query.bean.DatabaseConnection;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author juansari
 *
 */
public class DataSourceUtils {
	private static Logger logger = LoggerFactory.getLogger(DataSourceUtils.class);
	private static Map<String,JdbcTemplate> jdbcConnMap=new ConcurrentHashMap<>(10);
	
	
	/**
	 * Default datasource pool
	 * 
	 * @param connection
	 * @return
	 */
	public static DataSource createDatasource(DatabaseConnection connection) {
		final HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(connection.getConnectionType());
		ds.setJdbcUrl(connection.getConnectionUrl());
		ds.setUsername(connection.getUser());
		ds.setPassword(PasswordUtil.decrypt(connection.getPassword()));
		return ds;
	}
	/**
	 * On demand datasource should limit the pool size and has be closed after use
	 * 
	 * @param connection
	 * @param maxPoolSize
	 * @return
	 */
	public static DataSource createDatasource(DatabaseConnection connection,int maxPoolSize) {
		final HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(connection.getConnectionType());
		ds.setJdbcUrl(connection.getConnectionUrl());
		ds.setUsername(connection.getUser());
		ds.setPassword(PasswordUtil.decrypt(connection.getPassword()));		
		ds.setMaximumPoolSize(maxPoolSize);
		return ds;
	}
	public static JdbcTemplate getJdbcTemplate(DatabaseConnection conn) {
		String connKey=conn.getConnectionUrl()+conn.getUser()+conn.getPassword();
		if (jdbcConnMap.containsKey(connKey)) {
			logger.info("JDBC Template available for {}",connKey);
			return jdbcConnMap.get(connKey);
		} else {
			logger.info("Creating new JDBC Template for {}",connKey);
			JdbcTemplate newTemplate = new JdbcTemplate(createDatasource(conn,5));
			jdbcConnMap.put(connKey, newTemplate);			
			return newTemplate;
		}
	}


}
