package io.altar.stateMachine.jseproject.services;

import java.util.Collection;

import io.altar.stateMachine.jseproject.model.Product;
import io.altar.stateMachine.jseproject.repositories.ProductRepository;


public class ProductServices {
	
	ProductRepository productRepository1= ProductRepository.getInstance();
	
	
	public void createProduct(Product product1) {
		
		productRepository1.saveId(product1);
	}

	public void consultProduct() {
		
		productRepository1.consultAll();
	}
	
	

}
