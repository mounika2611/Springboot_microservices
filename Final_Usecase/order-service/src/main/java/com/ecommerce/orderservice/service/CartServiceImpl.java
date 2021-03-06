package com.ecommerce.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ecommerce.orderservice.entity.Item;
import com.ecommerce.orderservice.entity.Product;
import com.ecommerce.orderservice.feignclient.ProductClient;
import com.ecommerce.orderservice.repository.CartRepository;
import com.ecommerce.orderservice.utilities.CartUtilities;



@Service
public class CartServiceImpl implements CartService{

	
	@Autowired
    private ProductClient productClient;
	
	@Autowired
    private CartRepository cartRepository;

    @Override
    public void addItemToCart(String cartId, Long productId, Integer quantity) {
        Product product = productClient.getProductById(productId);
        Item item = new Item(quantity,product, CartUtilities.getSubTotalForItem(product,quantity));
        cartRepository.addItemToCart(cartId, item);
    }
	


    @Override
    public List<Object> getCart(String cartId) {
        return (List<Object>)cartRepository.getCart(cartId, Item.class);
    }

    @Override
    public void changeItemQuantity(String cartId, Long productId, Integer quantity) {
        List<Item> cart = (List)cartRepository.getCart(cartId, Item.class);
        for(Item item : cart){
            if((item.getProduct().getId()).equals(productId)){
            	cartRepository.deleteItemFromCart(cartId, item);
                item.setQuantity(quantity);
                item.setSubTotal(CartUtilities.getSubTotalForItem(item.getProduct(),quantity));
                cartRepository.addItemToCart(cartId, item);
            }
        }
    }

    @Override
    public void deleteItemFromCart(String cartId, Long productId) {
        List<Item> cart = (List) cartRepository.getCart(cartId, Item.class);
        for(Item item : cart){
            if((item.getProduct().getId()).equals(productId)){
            	cartRepository.deleteItemFromCart(cartId, item);
            }
        }
    }

    @Override
    public boolean checkIfItemIsExist(String cartId, Long productId) {
        List<Item> cart = (List) cartRepository.getCart(cartId, Item.class);
        for(Item item : cart){
            if((item.getProduct().getId()).equals(productId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Item> getAllItemsFromCart(String cartId) {
        List<Item> items = (List)cartRepository.getCart(cartId, Item.class);
        return items;
    }

    @Override
    public void deleteCart(String cartId) {
    	cartRepository.deleteCart(cartId);
    }

}
