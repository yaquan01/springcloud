package com.tedu.sp06;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

//@EnableDiscoveryClient      //注册发现客户端 
//@SpringBootApplication     
//@EnableCircuitBreaker		 //熔断器  
@SpringCloudApplication		
public class Sp06RibbonApplication {

	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		SimpleClientHttpRequestFactory f=new SimpleClientHttpRequestFactory();
		f.setConnectTimeout(1000);
		f.setReadTimeout(1000);
		return new RestTemplate(f);
	}
	public static void main(String[] args) {
		SpringApplication.run(Sp06RibbonApplication.class, args);
	}

}
