package com.dlqudwp.allin.like.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository {
	
	int addToCart(@Param("userId") int userId, @Param("productId") int productId);

}
