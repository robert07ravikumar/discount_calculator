/**
 * 
 */
package com.retail.discount.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.retail.discount.Bill;
import com.retail.discount.Customer;
import com.retail.discount.NetAmountCalculatorService;

/**
 * @author Robert Ravikumar
 *
 */
public class NetAmountCalculatorServiceTest {

	Customer cust ;
	Bill bill ;

	@Before
	public void init() {
		cust = new Customer();

		bill = new Bill();
		bill.setGrocery(new BigDecimal(431));
		bill.setOtherItems(new BigDecimal(600));

		cust.setBill(bill);
	}

	@Test
	public final void testCalculateDiscountEmployeewithoutYears() throws Exception {

		cust.setType("EMPLOYEE");
		cust.setNoOfYears(1);

		BigDecimal expected = new BigDecimal(842.50).setScale(2,BigDecimal.ROUND_HALF_EVEN);

		assertEquals(expected, NetAmountCalculatorService.calculateDiscount(cust)); 
	}

	@Test
	public final void testCalculateDiscountEmployeewithyears() throws Exception {

		cust.setType("EMPLOYEE");
		cust.setNoOfYears(15);

		BigDecimal expected = new BigDecimal(990.99).setScale(2,BigDecimal.ROUND_HALF_EVEN);

		assertEquals(expected, NetAmountCalculatorService.calculateDiscount(cust)); 
	}

	@Test
	public final void testCalculateDiscountAffliateWithoutyears() throws Exception {

		cust.setType("AFFLIATE");
		cust.setNoOfYears(1);

		BigDecimal expected = new BigDecimal(961.30).setScale(2,BigDecimal.ROUND_HALF_EVEN);

		assertEquals(expected, NetAmountCalculatorService.calculateDiscount(cust)); 
	}


	@Test
	public final void testCalculateDiscountAffliateWithYears() throws Exception {

		cust.setType("AFFLIATE");
		cust.setNoOfYears(15);

		BigDecimal expected = new BigDecimal(990.99).setScale(2,BigDecimal.ROUND_HALF_EVEN);

		assertEquals(expected, NetAmountCalculatorService.calculateDiscount(cust)); 
	}
	
	
	@Test(expected = Exception.class)
	public final void testCalculateDiscountAffliateWithYear() throws Exception {

		cust.setType("");
		cust.setNoOfYears(15);

		NetAmountCalculatorService.calculateDiscount(cust);

	}
}
