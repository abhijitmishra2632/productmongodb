package com.cosmos.product.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmos.product.model.Product;
import com.cosmos.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(Long productId) {
		// TODO Auto-generated method stub
		Product p = productRepository.findById(productId).get();
		System.out.println(p);
		return p;
	}

	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		//Product pr=Optional.ofNullable(product).orElse();
		Product saved = productRepository.save(product);
		return saved;
	}

	private Product addDummyProduct() {
		// TODO Auto-generated method stub
		Product p =new Product(1L,"Harada Dali","Dali",1000,90);
		return p;
	}

	public String deleteProduct(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
