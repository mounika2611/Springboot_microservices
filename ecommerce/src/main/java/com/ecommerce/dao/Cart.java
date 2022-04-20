package com.ecommerce.dao;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="orderList")
public class Cart {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer orderId;


private Date createdDate;

@ManyToOne
@JoinColumn(name= "product_id")

private Product product;

@ManyToOne
@JoinColumn(name= "user_id")
private User user;

private int quantity;



// public Cart() {
//
// }



public Integer getOrderId() {
return orderId;
}



public void setOrderId(Integer orderId) {
this.orderId = orderId;
}



public Date getCreatedDate() {
return createdDate;
}



public void setCreatedDate(Date createdDate) {
this.createdDate = createdDate;
}



public Product getProduct() {
return product;
}



public void setProduct(Product product) {
this.product = product;
}



public User getUser() {
return user;
}



public void setUser(User user) {
this.user = user;
}



public int getQuantity() {
return quantity;
}



public void setQuantity(int quantity) {
this.quantity = quantity;
}
}