package com.in28minutes.microservices.netflixzuulapigatewayserver;

import brave.sampler.Sampler;
import com.in28minutes.microservices.netflixzuulapigatewayserver.beans.AlwaysSampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}

	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}


	@Bean
	public Sampler defSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}
}
