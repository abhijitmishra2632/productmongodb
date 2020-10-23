package com.cosmos.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmos.product.model.Product;
import com.cosmos.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
		return new ResponseEntity<>(productService.getProductById(productId),HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Product> createTutorial(@RequestBody Product product) {
		  try {
			  Product savedproduct = productService.saveProduct(product);
			  return new ResponseEntity<>(savedproduct, HttpStatus.CREATED);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
		}
	@DeleteMapping
	public String deleteProduct(@PathVariable Long productId) {
		return productService.deleteProduct(productId);
	}

}
