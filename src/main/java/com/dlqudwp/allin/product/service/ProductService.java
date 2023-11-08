package com.dlqudwp.allin.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dlqudwp.allin.comment.dto.CommentDetail;
import com.dlqudwp.allin.comment.service.CommentService;
import com.dlqudwp.allin.common.FileManager;
import com.dlqudwp.allin.like.service.LikeService;
import com.dlqudwp.allin.product.domain.Product;
import com.dlqudwp.allin.product.dto.ProductDetail;
import com.dlqudwp.allin.product.repository.ProductRepository;
import com.dlqudwp.allin.user.domain.User;
import com.dlqudwp.allin.user.service.UserService;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LikeService likeService;
	
	@Autowired
	private CommentService commentService;
	
	
	public int deleteProduct(int userId) {
		
		Product product = productRepository.selectProduct(userId);
		
		if(product.getUserId() != userId) {
			return 0;
		}
		
		FileManager.removeFile(product.getImagePath());
	
		commentService.deleteCommentByProductId(userId);
		
		likeService.deleteLikeByProductId(userId);
		
		return productRepository.deleteProduct(userId);
		
	}
	
	
	public int addProduct(int userId, String productName, String content, MultipartFile file, int price) {
		
		String imagePath = FileManager.saveFile(userId, file);
		
		return productRepository.insertProduct(userId, productName, content, imagePath, price);
		
	}
	
	public List<ProductDetail> getProductList(int productId) {
	
		List<Product> productList = productRepository.selectProductList();
		List<ProductDetail> productDetailList = new ArrayList<>();
		for(Product product:productList) {
			
			int userId = product.getUserId();
			User user = userService.getUserById(userId);
			
			
			int likeCount = likeService.countLike(product.getUserId());
			boolean isLike = likeService.isLike(product.getId(), userId);
			
			List<CommentDetail> commentList = commentService.getCommentList(product.getId());
			
			ProductDetail productDetail = ProductDetail.builder()
									.id(product.getId())
									.productId(productId)
									.content(product.getContent())
									.imagePath(product.getImagePath())
									.price(product.getPrice())
									.likeCount(likeCount)
									.isLike(isLike)
									.commentList(commentList)
									.build();
			
			productDetailList.add(productDetail);
		}
		
		return productDetailList;
		
	}
}
