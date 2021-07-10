package com.evolvus.camel.service;

import org.springframework.stereotype.Component;

@Component
public class SampleServiceImpl implements SampleService {

	public String getRefNumber(String str) {

		Long ref = System.currentTimeMillis();

		return str + ref.toString();
	}

}
