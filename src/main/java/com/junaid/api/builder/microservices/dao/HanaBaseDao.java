/**
 * 
 */
package com.junaid.api.builder.microservices.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.junaid.api.builder.util.QueryProperties;

/**
 * @author juansari
 *
 */
@Component
public class HanaBaseDao {
	
	protected Logger logger=LoggerFactory.getLogger(HanaBaseDao.class);
	
    @Autowired
    protected QueryProperties queryProperties;
   
}
