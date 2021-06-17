/**
 * 
 */
package com.ece.apache;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ece.apache.bean.CBSResponse;

/**
 * @author user
 *
 */
@Component
public class PostingProcessor implements Processor {
	
	
	@Autowired
	RestTemplate resttempl;

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("the file posting processor "+exchange.getIn().getBody().toString());
		List li=(ArrayList) exchange.getIn().getBody();
		String name=(String) li.get(0);
		String url="https://serene-spire-67366.herokuapp.com/rest/postaccout-json";
		String req="{\n"
				+ " \"Name\": \"%s\",\n"
				+ " \"BranchName\": \"RT Nagar\",\n"
				+ " \"AccountNumber\": \"%s\",\n"
				+ " \"Amount\": 900.05,\n"
				+ " \"IFSC\": \"INDB0000001\"\n"
				+ "}";
		
	String	uniqueNumber=RandomStringUtils.randomNumeric(10);
		
		String finalRes=String.format(req, name,uniqueNumber);
		HttpHeaders headers=new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		
		
		HttpEntity requestEntity=new HttpEntity(finalRes,headers);
		String successMsg=null;
		String cbsrefnum=null;
		try {
		ResponseEntity<CBSResponse> resp=	resttempl.exchange(url, HttpMethod.POST, requestEntity, CBSResponse.class);
		
		System.out.println(resp.getBody());
		successMsg=resp.getBody().getMsg();
		cbsrefnum=resp.getBody().getAccountNumber();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		String initialString = "text";
	    InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
	    
		exchange.getIn().setBody(successMsg);
		exchange.getIn().setHeader("camelFileName",uniqueNumber+".txt");
		exchange.getIn().setHeader("successmsg",successMsg);
		exchange.getIn().setHeader("refnumber",uniqueNumber);

		exchange.getIn().setHeader("cbsref",cbsrefnum);




		

	}

}
