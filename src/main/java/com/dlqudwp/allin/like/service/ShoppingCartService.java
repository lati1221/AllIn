package com.dlqudwp.allin.like.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlqudwp.allin.like.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {
	
	@Autowired
    private ShoppingCartRepository cartRepository;

    public int addToCart(int userId, int productId) {
        return cartRepository.addToCart(userId, productId);
    }

    
    
}
