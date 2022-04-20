package com.ecommerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.common.ApiResponse;
import com.ecommerce.dao.User;
import com.ecommerce.dto.AddToCartDto;
import com.ecommerce.dto.CartDto;
import com.ecommerce.service.AuthenticationService;
import com.ecommerce.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {



@Autowired
private CartService cartService;

@Autowired
AuthenticationService authenticationService;





@PostMapping("/add")
public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam String token){
// authenticate the token
authenticationService.authenticate(token);
User user = authenticationService.getUser(token);

cartService.addTocart(addToCartDto, user );
return new ResponseEntity<>(new ApiResponse(true, "Added to Cart"), HttpStatus.CREATED);
}
@GetMapping("/")
public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token,@RequestParam int accountNumber){
authenticationService.authenticate(token);





User user = authenticationService.getUser(token);

// get cart Items
CartDto cartDto = cartService.listCartItems(user,accountNumber);
return new ResponseEntity<>(cartDto,HttpStatus.OK);
}

@DeleteMapping("/delete/{CartItemId}")
public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("CartItemId")Integer ItemId, @RequestParam("tokens")String token){

User user = authenticationService.getUser(token);

cartService.deleteCartItem(ItemId, user);
return new ResponseEntity<>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
}
}