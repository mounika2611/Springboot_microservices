package com.ecommerce.orderservice.utilities;

import java.math.BigDecimal;

import com.ecommerce.orderservice.entity.Product;

public class CartUtilities {

	 public static BigDecimal getSubTotalForItem(Product product, int quantity){
	       return (product.getPrice()).multiply(BigDecimal.valueOf(quantity));
	    }
}
