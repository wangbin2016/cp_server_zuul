package com.caipiao.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.ZuulServerMarkerConfiguration;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.caipiao.zuul.filter.LoginCheckFilter;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@Configuration
public class CpZuulApplication {
	public static void main(String[] args) {
		//SpringApplication.run(CpZuulApplication.class, args);
		 new SpringApplicationBuilder(CpZuulApplication.class).web(true).run(args);
	}
	
	@Bean
	public LoginCheckFilter loginCheckFilter() {
		return new LoginCheckFilter();
	}
}
