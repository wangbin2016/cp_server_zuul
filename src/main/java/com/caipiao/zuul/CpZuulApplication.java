package com.caipiao.zuul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
