package com.junaid.api.builder.querymapper.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.junaid.api.builder.model.db.Column;
import com.junaid.api.builder.querymapper.query.bean.ReportConfigDatabase;


public class ApiBuilderUtility {

	public static String colmunsNamesComaSperated(List<String> columnList) {
		if (columnList == null || columnList.isEmpty()) {
			return "*";
		}
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (String s : columnList) {
			if (flag)
				sb.append(",");
			sb.append("\"").append(s).append("\"");

			flag = true;
		}
		return sb.toString();
	}

	public static String colmunsNamesComaSperated(List<String> columnList, ReportConfigDatabase reportDb) {
		List<String> selColumnList = columnList;
		if (columnList == null || columnList.isEmpty()) {
			if ("yes".equalsIgnoreCase(reportDb.getIsDefaultColumns())) {
				selColumnList = getDefaultColumns(reportDb.getDefaultSelectColumns());
			} else {
				return "*";
			}
		}
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (String s : selColumnList) {
			if (flag)
				sb.append(",");
			sb.append("\"").append(s).append("\"");

			flag = true;
		}
		return sb.toString();
	}

	public static List<String> getDefaultColumns(Map<String, Column> columns) {
		return columns.keySet().stream().collect(Collectors.toList());
	}
}