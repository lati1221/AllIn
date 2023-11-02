package com.dlqudwp.allin.product.dto;

import java.util.List;

import com.dlqudwp.allin.comment.dto.CommentDetail;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDetail {
	
	private int id;
	private int productId;
	private String content;
	private String imagePath;
	private int likeCount;
	private boolean isLike;
	private List<CommentDetail> commentList;

}
