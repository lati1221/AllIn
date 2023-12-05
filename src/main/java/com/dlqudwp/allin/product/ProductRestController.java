package com.dlqudwp.allin.product;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dlqudwp.allin.product.service.ProductService;

@RequestMapping("/product")
@RestController
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@DeleteMapping("/delete")
	public Map<String, String> deleteProduct(
			@RequestParam("productId") int productId
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		int count = productService.deleteProduct(userId);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	
	@PostMapping("/create")
	public Map<String, String> createProduct(
			 @RequestParam("content") String content
			, @RequestParam("productName") String productName
			, @RequestParam("imageFile") MultipartFile file
			, @RequestParam("price") int price
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = productService.addProduct(userId, productName, content, file, price);
		
		Map<String, String> resultMap = new HashMap<>();	
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	

	
}
