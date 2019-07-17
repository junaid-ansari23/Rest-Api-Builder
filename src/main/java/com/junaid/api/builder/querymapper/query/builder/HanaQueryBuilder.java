package com.junaid.api.builder.querymapper.query.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.junaid.api.builder.model.db.Column;
import com.junaid.api.builder.model.request.Order;
import com.junaid.api.builder.model.request.Pagination;
import com.junaid.api.builder.model.request.ReportInput;
import com.junaid.api.builder.querymapper.query.bean.QueryInput;
import com.junaid.api.builder.querymapper.query.bean.QueryOutPut;
import com.junaid.api.builder.querymapper.query.bean.ReportConfig;
import com.junaid.api.builder.querymapper.query.bean.ReportConfigDatabase;
import com.junaid.api.builder.querymapper.query.constants.QueryConstant;
import com.junaid.api.builder.querymapper.util.ApiBuilderUtility;
import com.junaid.api.builder.util.CommonUtils;


public class HanaQueryBuilder{
	protected Logger logger = LoggerFactory.getLogger(HanaQueryBuilder.class);

	private List<ReportConfig> repConfig = null;
	private List<ReportConfigDatabase> repConfigdb = null;

	public List<QueryOutPut> buildDBQuery(ReportInput input) {
		List<QueryOutPut> collection = new ArrayList<QueryOutPut>();

		List<ReportConfigDatabase> reportList = getRepConfigdb();
		for (ReportConfigDatabase reportConfig : reportList) {
			StringBuilder sb = new StringBuilder();
			// to check query mode
			if ("yes".equalsIgnoreCase(reportConfig.getQueryMode())) {
				String query = reportConfig.getDatabaseQuery();
				if (query != null && !QueryConstant.EMPTY.equals(reportConfig.getDatabaseQuery())) {
					sb.append(query);
				} else {
					// set error message
				}

			} else {

				// StringBuilder sb = new StringBuilder();
				sb.append(QueryConstant.SELECT);
				sb.append(ApiBuilderUtility.colmunsNamesComaSperated(input.getColumns(), reportConfig));
				// aggregation clause
				/*
				 * if(input.get) {
				 * 
				 * }
				 */
				sb.append(QueryConstant.SPACE);
				sb.append(QueryConstant.FROM);
				sb.append(QueryConstant.SPACE);
				sb.append(reportConfig.getDatabaseView());
			}

			List<Map<String, List<Object>>> filterMap = input.getFilters();

			if (filterMap != null && !filterMap.isEmpty()) {
				sb.append(QueryConstant.SPACE);
				sb.append(QueryConstant.WHERE);
				sb.append(QueryConstant.SPACE);
				for (Map<String, List<Object>> inputFilter : filterMap) {
					for (Map.Entry<String, List<Object>> e : inputFilter.entrySet()) {
						String colkey = e.getKey();
						//Column column = reportConfig.getAvailableColumns().get(colkey);
						sb.append(colkey).append(QueryConstant.SPACE).append(QueryConstant.IN)
								.append(QueryConstant.SPACE).append(QueryConstant.OPEN_BRACKET)
								//store the columns' datatype in registration object,for now all treated as string
								.append(getValueForInClause(e.getValue(), "String"))
								.append(QueryConstant.CLOSE_BRACKET).append(QueryConstant.SPACE)
								.append(QueryConstant.AND).append(QueryConstant.SPACE);
					}
				}
				// remove additional and from string
				int strLength = sb.length();
				sb = new StringBuilder(sb.substring((0), (strLength - 5)));
			}
			if (input.getOrders() != null && input.getOrders().getOrderBy() != null) {
				sb.append(QueryConstant.SPACE).append(HanaQueryBuilder.getOrderBy(input.getOrders()));
			}			
			if (input.getPaging() != null) {
				sb.append(QueryConstant.SPACE).append(HanaQueryBuilder.getPagination(input.getPaging()));
			}
			QueryOutPut output = new QueryOutPut();
			logger.info("final query: {}", sb.toString());
			output.setQuery(sb.toString());
			output.setTableName(reportConfig.getDatabaseView());
			output.setDataSourceName(reportConfig.getDatabase());
			output.setIsSecured(reportConfig.getIsSecured());
			collection.add(output);
		}
		return collection;

	}

	public static String getColumnTypeFromName(Column column, String colName) {
		return column.getType();
	}

	public static String getValueForInClause(List<Object> values, String type) {
		StringBuilder sb = new StringBuilder();
		for (Object value : values) {
			if ("String".equalsIgnoreCase(type)) {
				sb.append(QueryConstant.QUOTE).append(value).append(QueryConstant.QUOTE);
			} else {
				sb.append(value);
			}
			sb.append(QueryConstant.COMMA);
		}
		return (sb.subSequence(0, sb.length() - 1)).toString();
	}

	public static String getOrderBy(Order order) {
		String orderByString = CommonUtils.convertListToCommaString(order.getOrderBy());
		if (!QueryConstant.EMPTY.equals(orderByString)) {
			String dir = order.getDirection();
			if (dir == null) {
				dir = "ASC";
			}
			return (QueryConstant.ORDER_BY + QueryConstant.SPACE + orderByString + QueryConstant.SPACE + dir);
		} else {
			return QueryConstant.EMPTY;
		}

	}

	public static String getPagination(Pagination pag) {
		String limit = pag.getLimit();
		if (limit == null) {
			limit = String.valueOf(QueryConstant.RECORD_LIMIT);
		}
		String paging = QueryConstant.LIMIT + QueryConstant.SPACE + limit;
		if (pag.getOffset() != null) {
			paging = paging + QueryConstant.SPACE + QueryConstant.OFFSET + QueryConstant.SPACE + pag.getOffset();
		}
		return paging;
	}

	public static String getOrderBy(List<Order> list) {
		Order ord = list.get(0);
		return (QueryConstant.ORDER_BY + QueryConstant.SPACE + ord.getOrderBy() + QueryConstant.SPACE
				+ ord.getDirection());
	}

	public static String getFilter(QueryInput input) {
		return input.getFilterName() != null ? input.getFilterName() : QueryConstant.EMPTY;
	}

	public static String getGroupBy(QueryInput input) {
		if (input.getGroupBy() != null && !input.getGroupBy().isEmpty()) {
			String columnsCommaSperated = (ApiBuilderUtility.colmunsNamesComaSperated(input.getGroupBy()));
			return QueryConstant.GROUP_BY + columnsCommaSperated;
		}
		return QueryConstant.EMPTY;
	}

	public List<ReportConfig> setReportConfig(List<ReportConfig> rConfig) {
		return this.repConfig = rConfig;
	}

	public List<ReportConfig> getReportConfig() {
		return this.repConfig;
	}

	/**
	 * @return the repConfigdb
	 */
	public List<ReportConfigDatabase> getRepConfigdb() {
		return repConfigdb;
	}

	/**
	 * @param repConfigdb
	 *            the repConfigdb to set
	 */
	public void setRepConfigdb(List<ReportConfigDatabase> repConfigdb) {
		this.repConfigdb = repConfigdb;
	}

}
