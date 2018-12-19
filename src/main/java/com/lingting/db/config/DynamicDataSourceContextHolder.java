package com.lingting.db.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态数据源上下文管理
 * 
 * @author wengjc
 *
 */
public class DynamicDataSourceContextHolder {
	// 存放当前线程使用的数据源类型信息
	private static final ThreadLocal<String> CONTEXTHOLDER = new ThreadLocal<String>();
	// 存放数据源id
	public static List<String> dataSourceIds = new ArrayList<String>();

	// 设置数据源
	public static void setDataSourceType(String dataSourceType) {
		CONTEXTHOLDER.set(dataSourceType);
	}

	// 获取数据源
	public static String getDataSourceType() {
		return CONTEXTHOLDER.get();
	}

	// 清除数据源
	public static void clearDataSourceType() {
		CONTEXTHOLDER.remove();
	}

	// 判断当前数据源是否存在
	public static boolean isContainsDataSource(String dataSourceId) {
		return dataSourceIds.contains(dataSourceId);
	}
}
