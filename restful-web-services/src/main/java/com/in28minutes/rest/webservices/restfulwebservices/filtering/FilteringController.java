package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

	@GetMapping(path = "/filtering")
	public MappingJacksonValue someBean(){
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters); // dynamic filtering
		return mapping;
	}

	@GetMapping(path = "/filtering-list")
	public MappingJacksonValue someBeanList(){
		List<SomeBean> someBeans = Arrays.asList(
				new SomeBean("value1", "value2", "value3"),
				new SomeBean("value12", "value22", "value32"),
				new SomeBean("value13", "value23", "value33"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBeans);
		mapping.setFilters(filters); // dynamic filtering
		return mapping;
	}
}

