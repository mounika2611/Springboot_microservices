
package com.ecommerce.exception;

public class ProductNotExistException extends IllegalArgumentException {
	public ProductNotExistException(String msg) {
		super(msg);
	}
}
