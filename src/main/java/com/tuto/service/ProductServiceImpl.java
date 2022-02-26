package com.tuto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuto.model.Product;
import com.tuto.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
	}
	
	@Override
	public long numberOfProducts() {
		return productRepository.count();
	}
	
	@Override
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}
}
