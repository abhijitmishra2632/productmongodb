package com.cosmos.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "product")
@Getter @Setter @NoArgsConstructor
public class Product {
	@Id
	private Long productId;
	private String productName;
	private String productCategory;
	private int productSize;
	private int productPrice;
	public Product(Long productId, String productName, String productCategory, int productSize, int productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productSize = productSize;
		this.productPrice = productPrice;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productSize=" + productSize + ", productPrice=" + productPrice + "]";
	}
		
}
