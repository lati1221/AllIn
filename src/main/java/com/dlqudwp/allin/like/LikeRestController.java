package com.dlqudwp.allin.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dlqudwp.allin.like.service.LikeService;

@RestController
public class LikeRestController {

	@Autowired
	private LikeService likeService;
	
	@PostMapping("/product/like")
	public Map<String, String> like(
			@RequestParam("productId") int productId
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = likeService.addLike(productId, userId);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("reslut", "fail");
		}
		return resultMap;
		
	}
	
	@DeleteMapping("/product/unlike")
	public Map<String, String> unlike(
			@RequestParam("productId") int productId
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = likeService.deleteLikeByProductIdAndUserId(productId, userId);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
		
	}
	

}
