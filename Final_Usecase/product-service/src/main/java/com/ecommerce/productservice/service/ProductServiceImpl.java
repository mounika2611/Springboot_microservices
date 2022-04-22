package com.ecommerce.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.repository.ProductRepository;


@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	 @Autowired
	    private ProductRepository productRepository;
	 
	@Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
	@Override
    public List<Product> getAllProductByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }
	 
   

    @Override
    public List<Product> getAllProductsByName(String name) {
        return productRepository.findAllByProductName(name);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
	@Override
	public Product getProductById(long id) {
		
		return  productRepository.getById(id);
	}
	
	
}
