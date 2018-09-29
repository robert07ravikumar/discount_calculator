package com.retail.discount;

import java.math.BigDecimal;

public interface DiscountStrategy {
	BigDecimal applyDiscount(BigDecimal amount);

    static DiscountStrategy employeeDiscount(){
        return amount -> amount.multiply(BigDecimal.valueOf(0.7));
    }

    static DiscountStrategy affliateDiscount(){
        return amount -> amount.multiply(BigDecimal.valueOf(0.9));
    }
    
    static DiscountStrategy loyaltyDiscount(){
        return amount -> amount.multiply(BigDecimal.valueOf(0.95));
    }
   
}
