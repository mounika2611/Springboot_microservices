package com.ecommerce.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.productservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
    public List<Product> findAllByCategory(String category);
    
    public List<Product> findAllByProductName(String name);
    
  
    

}
