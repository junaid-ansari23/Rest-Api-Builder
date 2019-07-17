/**
 * 
 */
package com.junaid.api.builder.querymapper.adapter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Component;

import com.junaid.api.builder.model.db.Row;

/**
 * @author juansari
 *
 */
@Component
public class HanaAdaptor implements DataAdaptor {

	@Override
	public CompletableFuture<List<Row>> getQueryData(List<String> queries) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> processQueryData(List<String> queries) {
		// TODO Auto-generated method stub
		return null;
	}

}
