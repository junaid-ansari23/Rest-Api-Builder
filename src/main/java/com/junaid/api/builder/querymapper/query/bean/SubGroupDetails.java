/**
 * 
 */
package com.junaid.api.builder.querymapper.query.bean;

import java.util.List;

import com.junaid.api.builder.model.request.Order;

/**
 * @author juansari
 *
 */
public class SubGroupDetails {
	
	private List<String> columns = null;
	private List<String> filters = null;
	private Order orders;
	private List<String> groupBy = null;	
	
	/**
	 * @return the columns
	 */
	public List<String> getColumns() {
		return columns;
	}
	/**
	 * @param columns the columns to set
	 */
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	/**
	 * @return the filters
	 */
	public List<String> getFilters() {
		return filters;
	}
	/**
	 * @param filters the filters to set
	 */
	public void setFilters(List<String> filters) {
		this.filters = filters;
	}
	/**
	 * @return the orders
	 */
	public Order getOrders() {
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Order orders) {
		this.orders = orders;
	}
	/**
	 * @return the groupBy
	 */
	public List<String> getGroupBy() {
		return groupBy;
	}
	/**
	 * @param groupBy the groupBy to set
	 */
	public void setGroupBy(List<String> groupBy) {
		this.groupBy = groupBy;
	}

}
