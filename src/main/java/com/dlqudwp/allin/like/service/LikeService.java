package com.dlqudwp.allin.like.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlqudwp.allin.like.repository.LikeRepository;

@Service
public class LikeService {
	
	@Autowired
	private LikeRepository likeRepository;
	
	public int addLike(int productId, int userId) {
		return likeRepository.insertLike(productId, userId);
	}
	
	public int countLike(int productId) {
		return likeRepository.selectCountLike(productId);
	}
	
	public boolean isLike(int productId, int userId) {
		int count = likeRepository.selectCountLikeByUserId(productId, userId);
		
		return count != 0;
	}
	
	public int deleteLikeByPostId(int productId) {
		return likeRepository.deleteLikeByProductId(productId);
	}
	
	public int deleteLikeByProductIdAndUserId(int productId, int userId) {
		return likeRepository.deleteLikeByProductIdAndUserId(productId, userId);
	}



}
