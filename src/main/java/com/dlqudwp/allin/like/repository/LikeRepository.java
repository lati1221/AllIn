package com.dlqudwp.allin.like.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dlqudwp.allin.user.domain.User;

@Repository
public interface LikeRepository {
	
	public int insertLike(
			@Param("productId") int productId
			, @Param("userId") int userId);
	
	public int selectCountLike(
			@Param("productId") int productId);
	
	public int selectCountLikeByUserId(
			@Param("productId") int productId
			, @Param("userId") int userId);
	
	public int deleteLikeByProductId(@Param("productId") int productId);
	
	public int deleteLikeByProductIdAndUserId(
			@Param("productId") int productId
			, @Param("userId") int userId);


}
