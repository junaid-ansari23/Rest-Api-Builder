/**
 * 
 */
package com.junaid.api.builder.querymapper.adapter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.junaid.api.builder.model.db.Row;

/**
 * @author juansari
 *
 */
public interface DataAdaptor {
	public CompletableFuture<List<Row>> getQueryData(List<String> queries);
	public List<Map<String, Object>> processQueryData(List<String> queries);
}
