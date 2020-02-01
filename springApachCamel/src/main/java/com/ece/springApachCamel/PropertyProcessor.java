/**
 * 
 */
package com.ece.springApachCamel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @author user
 *
 */
public class PropertyProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("the  propertprocessor::::::::"+exchange.getProperties());
		
		exchange.setProperty("branchName", "ECE");
		
	}

}
