package com.cn.erp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

import test.cn.com.utils.SolrUtil;

@EnableScheduling//启动quartz定时器
@org.springframework.boot.autoconfigure.SpringBootApplication(exclude = SolrAutoConfiguration.class)//禁用Solr的自动配置
public class SpringBootApplication {
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(SolrUtil.class);
	    }
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}

}
