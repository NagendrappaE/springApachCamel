/**
 * 
 */
package com.ece.springApachCamel;

/**
 * @author user
 *
 */
public class InterMediateProcessor {

	public void dataprocess(String idVal,String adat) {

		System.out.println("hiiiiiii" + idVal);
	}

	public void callAccountEnquiry(String accNum) {
		System.out.println("inside the acc enquiry");

	}

	public void callAccountStatus(String status) {

		System.out.println("the account status of the " + status);
	}

	public void callAccountClosed(String va) {
		System.out.println("accccclosed" + va);

	}
	
	public  void  collageINFO(College collage) {
		
		System.out.println("inside the colge");
	}
}
