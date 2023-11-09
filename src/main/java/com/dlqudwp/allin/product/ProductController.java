package com.dlqudwp.allin.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/search")
    public String searchProducts(@RequestParam("keyword") String keyword, Model model) {
        List<ProductDetail> searchResults = productService.searchProducts(keyword);
        model.addAttribute("searchResults", searchResults);
        return "main/mainpage"; 
    }

	
}
