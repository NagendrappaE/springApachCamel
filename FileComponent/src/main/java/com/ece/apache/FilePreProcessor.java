package com.ece.apache;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class FilePreProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		
		String fileName=(String) exchange.getIn().getHeader("camelFileName");
		
		System.out.println("the file "+exchange.getIn().getBody().toString());
		
		long size= (long) exchange.getIn().getHeader("camelFileSize");
		
		if(size==0) {
			throw new FileNotFoundException("The file with the zero KB"+fileName);
		}
		System.out.println("file Zise"+size);
		
		//exchange.getIn().setBody("We should creack GATE ");//it can be object
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ObjectOutputStream oos = new ObjectOutputStream(baos);

	     MyBankAccount obje  = new MyBankAccount();
	     obje.setAccountNum("ddd");
	     
	    oos.writeObject(obje);

	    oos.flush();
	    oos.close();

	    InputStream is = new ByteArrayInputStream(baos.toByteArray());
		
		exchange.getIn().setBody(is);
		exchange.getIn().setHeader("camelFileName", new Date()+fileName);
		
		
	}

}
