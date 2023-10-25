package com.dlqudwp.allin.product.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dlqudwp.allin.product.domain.Product;

@Repository
public interface ProductRepository {
	
	public int insertProduct(
			@Param("userId") int userId
			, @Param("productName") String productName
			, @Param("content") String content
			, @Param("imagePath") String imagePath
			, @Param("price") int price);
	
	
	public Product selectProduct(@Param("postId") int productId);
	public List<Product> selectProductList();

	
	public int deleteProduct(@Param("postId") int productId);

}
