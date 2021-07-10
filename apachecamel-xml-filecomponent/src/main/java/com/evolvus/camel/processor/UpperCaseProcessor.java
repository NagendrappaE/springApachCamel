package com.evolvus.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class UpperCaseProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub

		System.out.println(" the  file  content " + exchange.getIn().getBody().toString());

		String fileName = (String) exchange.getIn().getHeader("camelFileName");
		String refNum = (String) exchange.getIn().getHeader("uniqueRef");

		String completeFileName = refNum + fileName.toUpperCase();

		exchange.getIn().setHeader("camelFileName", completeFileName);

		String bodyStr = "Hi Welcome to apache camel program";

		exchange.getIn().setBody(bodyStr);

	}

}
