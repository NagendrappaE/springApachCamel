package com.ece.springApachCamel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("inside the camel processor");

		String originalFileContent = (String) exchange.getIn().getBody(String.class);
		String upperCaseFileContent = originalFileContent.toUpperCase();
		exchange.getIn().setBody(upperCaseFileContent);
		exchange.getIn().setHeader("accountNumber", "3335101002388");

		BankInfo info = new BankInfo();

		info.setBalance("12233333");
		info.setBankName("Indus ind bank");
		info.setIfsc("INDB0000001");
		char status = 'A';
		info.setStatus(status);

		exchange.getIn().setHeader("bankInfo", info);

		College college = new College();

		college.setCollegeName("government engineering college");
		college.setState("A");
		college.setUsn("4GK10EC031");

		exchange.setProperty("college", college);

	}

}
