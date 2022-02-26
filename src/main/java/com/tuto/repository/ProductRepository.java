package com.tuto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuto.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
