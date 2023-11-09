package com.dlqudwp.allin.comment.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlqudwp.allin.comment.domain.Comment;
import com.dlqudwp.allin.comment.dto.CommentDetail;
import com.dlqudwp.allin.comment.repository.CommentRepository;
import com.dlqudwp.allin.user.domain.User;
import com.dlqudwp.allin.user.service.UserService;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private UserService userService;
	
	public int addComment(int userId, int productId, String content) {
		
		return commentRepository.insertComment(userId, productId, content);
	}
	
	public List<CommentDetail> getCommentList(int productId) {
		
		List<Comment> commentList = commentRepository.selectCommentList(productId);
		
		List<CommentDetail> commentDetailList = new ArrayList<>();
		for(Comment comment:commentList) {
			
			int userId = comment.getUserId();
			User user = userService.getUserById(userId);
			
			CommentDetail commentDetail = CommentDetail.builder()
													.id(comment.getId())
													.userId(comment.getUserId())
													.content(comment.getContent())
													.loginId(user.getLoginId())
													.build();
			
			commentDetailList.add(commentDetail);
			
		}
		
		return commentDetailList;
		
	}
	
	public int deleteCommentByProductId(int productId) {
		return commentRepository.deleteCommentByProduct(productId);
	}
	

}
