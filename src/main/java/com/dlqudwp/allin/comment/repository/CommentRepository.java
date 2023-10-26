package com.dlqudwp.allin.comment.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dlqudwp.allin.comment.domain.Comment;

@Repository
public interface CommentRepository {
	
	public int insertComment(
			@Param("userId") int userId
			, @Param("productId") int productId
			, @Param("content") String content);
	
	public List<Comment> selectCommentList(@Param("productId") int productId);
	
	public int deleteCommentByPost(@Param("productId") int productId);
	

}
