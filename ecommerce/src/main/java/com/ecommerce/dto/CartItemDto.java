package com.ecommerce.dto;



import com.ecommerce.dao.Cart;
import com.ecommerce.dao.Product;



public class CartItemDto {
private Integer Id;
private Integer quantity;
private Product product;



public CartItemDto(Cart cart) {
this.Id = cart.getOrderId();
this.quantity = cart.getQuantity();
this.setProduct(cart.getProduct());



}



public Integer getId() {
return Id;
}



public void setId(Integer id) {
Id = id;
}



public Integer getQuantity() {
return quantity;
}



public void setQuantity(Integer quantity) {
this.quantity = quantity;
}



public Product getProduct() {
return product;
}



public void setProduct(Product product) {
this.product = product;
}



}