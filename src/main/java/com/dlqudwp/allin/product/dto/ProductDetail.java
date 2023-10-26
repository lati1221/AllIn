package com.dlqudwp.allin.product.dto;

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
	

}
