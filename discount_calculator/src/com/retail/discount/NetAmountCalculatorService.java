package com.retail.discount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NetAmountCalculatorService {

	public static BigDecimal calculateDiscount(Customer customer) throws UserNotValidException,Exception {

		DiscountStrategy discount = null;
		BigDecimal total = null;
		BigDecimal totalDiscount = null;

		try {

			switch (customer.getType()) {
				case "EMPLOYEE":
					discount = DiscountStrategy.employeeDiscount();
					break;
				case "AFFLIATE":
					discount = DiscountStrategy.affliateDiscount();
					break;
				default:
					throw new UserNotValidException();
			} 

			if(customer.getNoOfYears()>2){
				discount = DiscountStrategy.loyaltyDiscount();
			}

			total = discount.applyDiscount(customer.getBill().getOtherItems()).add(customer.getBill().getGrocery());

			totalDiscount = total.divide(new BigDecimal("100"), RoundingMode.FLOOR);
		}catch(Exception e) {
			throw e;
		}
		
		return total.subtract(totalDiscount).setScale(2,BigDecimal.ROUND_HALF_EVEN);
	}



}
