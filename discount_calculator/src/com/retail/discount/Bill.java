package com.retail.discount;

import java.math.BigDecimal;

public class Bill {
	
	private BigDecimal grocery;
	private BigDecimal otherItems;
	
	public BigDecimal getGrocery() {
		return grocery;
	}
	public void setGrocery(BigDecimal grocery) {
		this.grocery = grocery;
	}
	public BigDecimal getOtherItems() {
		return otherItems;
	}
	public void setOtherItems(BigDecimal otherItems) {
		this.otherItems = otherItems;
	}

}
