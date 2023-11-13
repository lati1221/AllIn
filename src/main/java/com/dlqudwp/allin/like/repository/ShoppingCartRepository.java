package com.dlqudwp.allin.like.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository {
	
	  int addToCart(int userId, int productId);
	  
	  int removeFromCart(int userId, int productId);
}
