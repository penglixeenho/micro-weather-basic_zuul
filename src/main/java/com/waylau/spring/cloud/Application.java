package com.waylau.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class Application {
//http://localhost:9980/weather/cityId/101280601
	//http://windows10.microdone.cn:9980/weather/cityId/101280601
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
