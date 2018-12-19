package com.lingting.db.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lingting.db.annotation.DataSource;
import com.lingting.db.config.DynamicDataSourceContextHolder;

import lombok.extern.log4j.Log4j2;

@Aspect
@Order(-1) // 保证在@Transactional之前执行
@Component
@Log4j2
public class DynamicDataSourceAspect {
	
	// 改变数据源
	@Before("@annotation(dataSource)")
	public void changeDataSource(JoinPoint joinPoint, DataSource dataSource) {
		String dbid = dataSource.value();

		if (!DynamicDataSourceContextHolder.isContainsDataSource(dbid)) {
			// joinPoint.getSignature() ：获取连接点的方法签名对象
			log.error("数据源[{}]不存在使用默认的数据源 -> {}", dbid, joinPoint.getSignature());
		} else {
			log.info("使用数据源：" + dbid);
			DynamicDataSourceContextHolder.setDataSourceType(dbid);
		}
	}

	@After("@annotation(dataSource)")
	public void clearDataSource(JoinPoint joinPoint, DataSource dataSource) {
		log.debug("清除数据源 [{}] !", dataSource.value());
		DynamicDataSourceContextHolder.clearDataSourceType();
	}
}
