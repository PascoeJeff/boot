package com.in28minutes.microservices.limitsservice;

import com.in28minutes.microservices.limitsservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private Configuration configuration;

	public LimitsConfigurationController(Configuration configuration) {
		this.configuration = configuration;
	}

	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration(){
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}
	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	public LimitConfiguration retrieveConfiguration(){
		throw new RuntimeException("ouch");
	}

	public LimitConfiguration fallbackRetrieveConfiguration(Throwable t){
		logger.error("In fallback",t);
		return new LimitConfiguration(999, 9);
	}
}
