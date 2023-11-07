package com.dlqudwp.allin.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

<<<<<<< HEAD
import com.dlqudwp.allin.product.domain.Product;
=======
>>>>>>> 22dcdce023c8fdb7a0e2f9c3efc7d840c95c7fb1
import com.dlqudwp.allin.product.dto.ProductDetail;
import com.dlqudwp.allin.product.service.ProductService;


@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/mainpage-view")
	public String productList(
			Model model
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		
		List<ProductDetail> productList = productService.getProductList(userId);
		
		model.addAttribute("productList", productList);
		return "main/mainpage";
	}
	

	
	
	
	
}
