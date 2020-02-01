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
public class PaymentProcessor  implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stubo
		String originalFileContent = (String) exchange.getIn().getBody(String.class);
		originalFileContent.toLowerCase();
		exchange.getIn().setBody(originalFileContent.toLowerCase());
		exchange.getIn().setHeader("accountNumber","3335101002388");
		
		exchange.setProperty("accStatus", "C");
		

		System.out.println("incoing data::::::"+exchange.getIn());
		
	}

}
