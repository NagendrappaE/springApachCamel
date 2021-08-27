package com.evolvus.apache.builder;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PoemProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("hiiiiiiii"+exchange.getIn().getBody());
		
		LOG.info("Hiiiiiiii "+exchange.getIn().getBody());
	}

}
