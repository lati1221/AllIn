package com.dlqudwp.allin.like.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlqudwp.allin.like.repository.LikeRepository;

@Service
public class LikeService {
	
	@Autowired
	private LikeRepository likeRepository;
	
	@Autowired
    private ShoppingCartService shoppingCartService; 

    public int addLike(int productId, int userId) {
        int likeResult = likeRepository.insertLike(productId, userId);
        
        if (likeResult == 1) {
            shoppingCartService.addToCart(userId, productId); // Add to cart when liked
        }

        return likeResult;
    }
    
    public int deleteLikeByProductIdAndUserId(int productId, int userId) {
        int unlikeResult = likeRepository.deleteLikeByProductIdAndUserId(productId, userId);
        
        if (unlikeResult == 1) {
            shoppingCartService.removeFromCart(userId, productId); // Remove from cart when unliked
        }

        return unlikeResult;
    }
    
	
	public int countLike(int productId) {
		return likeRepository.selectCountLike(productId);
	}
	
	public boolean isLike(int productId, int userId) {
		int count = likeRepository.selectCountLikeByUserId(productId, userId);
		
		return count != 0;
	}
	
	public int deleteLikeByProductId(int productId) {
		return likeRepository.deleteLikeByProductId(productId);
	}
	



}
