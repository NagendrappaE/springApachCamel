/**
 * 
 */
package com.evolvus.apache.builder;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author user
 *
 */
@Component
@Slf4j
public class RestRouteBuiilder  extends RouteBuilder{

	@Autowired
	private PoemProcessor poemProcessor;
	
	@Override
	public void configure() throws Exception {
		
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat(ResponseObj[].class);

		
String val="0 * * ? * *";
		
		System.out.println("hiii");
		fromF("cron:poemCron?schedule=%s",val).log("hiiidddd").setHeader(Exchange.HTTP_METHOD, constant("GET")).to("https://www.poemist.com/api/v1/randompoems").unmarshal(jsonDataFormat).process(poemProcessor);
		//from("timer://foo?fixedRate=true&period=60000").to("bean:myBean?method=someMethodName");

	}

}
