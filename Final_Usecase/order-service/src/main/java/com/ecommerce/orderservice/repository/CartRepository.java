package com.ecommerce.orderservice.repository;



import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.ecommerce.orderservice.entity.Item;
@Repository
public interface CartRepository  {

	public void addItemToCart(String cartId, Item item);
	

    public Collection<Object> getCart(String key, Class type);
    public void deleteItemFromCart(String key, Object item);
    public void deleteCart(String key);

}
