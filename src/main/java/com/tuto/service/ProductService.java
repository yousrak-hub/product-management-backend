package com.tuto.service;

import java.util.List;

import com.tuto.model.Product;

public interface ProductService {

	Product saveProduct(Product product);

	Product updateProduct(Product product);

	void deleteProduct(Long productId);

	long numberOfProducts();

	List<Product> findAllProducts();

}
