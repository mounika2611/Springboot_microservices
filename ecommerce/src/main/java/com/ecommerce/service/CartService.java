package com.ecommerce.service;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.Cart;
import com.ecommerce.dao.Product;
import com.ecommerce.dao.User;
import com.ecommerce.dto.AddToCartDto;
import com.ecommerce.dto.CartDto;
import com.ecommerce.dto.CartItemDto;
import com.ecommerce.exception.CustomException;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.UserRepository;



@Service
public class CartService {



@Autowired
ProductService productService;



@Autowired
CartRepository cartRepository;

@Autowired
UserRepository userRepository;


public void addTocart(AddToCartDto addToCartDto, User user) {
Product product = productService.findById(addToCartDto.getProductId());



Cart cart = new Cart();
cart.setProduct(product);
cart.setUser(user);
cart.setQuantity(addToCartDto.getQuantity());
cart.setCreatedDate(new Date());
cartRepository.save(cart);



}



public CartDto listCartItems(User user,int accountNumber) {
	
	double ecommerceBalance = 0;
	int counter=0;
List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);
List<CartItemDto> cartItems = new ArrayList<>();
double totalCost = 0;
for (Cart cart : cartList) {
CartItemDto cartItemDto = new CartItemDto(cart);

totalCost += cartItemDto.getQuantity() * cart.getProduct().getPrice();
cartItems.add(cartItemDto);
}

CartDto cartDto = new CartDto();
cartDto.setTotalCost(totalCost);
cartDto.setCartItem(cartItems);


for(User userDetails: userRepository.findAll())
    if(accountNumber == userDetails.getAccountNumber())
    {
  	  if(userDetails.getBalance()>= totalCost)
  	  {
  		  double remainingAmount = userDetails.getBalance() - totalCost;
  		  userRepository.updateTransactions(remainingAmount,userDetails.getAccountNumber());
  		  ecommerceBalance += totalCost;
  		  counter++;
  	  }
    }
    if(counter == 1)
    {
    	
  	  System.out.println("Transaction success");
    }
    else
    {
  	  System.out.println("Something went wrong");
    }

return cartDto;
}



public void deleteCartItem(Integer cartItemId, User user) {
Optional<Cart> optionalCart = cartRepository.findById(cartItemId);
if (!optionalCart.isPresent()) {
throw new CustomException("cart item id is invalid" + cartItemId);
}
Cart cart = optionalCart.get();
if (cart.getUser() != user) {
throw new CustomException("cart Item does not belong to user" + cartItemId);



}



cartRepository.delete(cart);
}



}