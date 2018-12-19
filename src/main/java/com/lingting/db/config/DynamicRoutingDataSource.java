package com.lingting.db.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import lombok.extern.log4j.Log4j2;

/**
 * 动态数据源路由配置
 * @author wengjc
 *
 */
@Log4j2
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		String dataSourceName = DynamicDataSourceContextHolder.getDataSourceType();
        log.info("当前数据源是：{}", dataSourceName);
        return DynamicDataSourceContextHolder.getDataSourceType();
	}

}
