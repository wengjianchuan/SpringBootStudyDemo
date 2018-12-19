package com.lingting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingting.db.aop.DynamicDataSourceAnnotationAdvisor;
import com.lingting.db.aop.DynamicDataSourceAnnotationInterceptor;
import com.lingting.db.register.DynamicDataSourceRegister;

/**
 * Hello world!
 *
 */
@Import(DynamicDataSourceRegister.class)
@SpringBootApplication
@EnableTransactionManagement
public class Application {

	@Bean
    public DynamicDataSourceAnnotationAdvisor dynamicDatasourceAnnotationAdvisor() {
        return new DynamicDataSourceAnnotationAdvisor(new DynamicDataSourceAnnotationInterceptor());
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/")
	String home() {
		return "index";
	}

}
