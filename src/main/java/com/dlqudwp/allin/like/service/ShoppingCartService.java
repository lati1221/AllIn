package com.dlqudwp.allin.like.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlqudwp.allin.like.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {
	
	 @Autowired
	    private ShoppingCartRepository shoppingCartRepository;

	    public void addToCart(int userId, int productId) {
	        
	        shoppingCartRepository.addToCart(userId, productId);
	    }
    
	    public void removeFromCart(int userId, int productId) {
	       
	        shoppingCartRepository.removeFromCart(userId, productId);
	    }
}
