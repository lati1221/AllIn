package com.dlqudwp.allin.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dlqudwp.allin.common.FileManager;
import com.dlqudwp.allin.product.domain.Product;
import com.dlqudwp.allin.product.repository.ProductRepository;
import com.dlqudwp.allin.user.domain.User;
import com.dlqudwp.allin.user.service.UserService;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserService userService;
	
	
	public int deleteProduct(int productId, int userId) {
		
		// 첨부된 파일 삭제 
		Product product = productRepository.selectProduct(productId);
		
		if(product.getUserId() != userId) {
			return 0;
		}
		
		FileManager.removeFile(product.getImagePath());
		
		return productRepository.deleteProduct(productId);
		
	}
	
	
	public int addProduct(int userId,String productName, String content, MultipartFile file, int price) {
		
		String imagePath = FileManager.saveFile(userId, file);
		
		return productRepository.insertProduct(userId, productName, content, imagePath, price);
		
	}
	
	
	
	
}
