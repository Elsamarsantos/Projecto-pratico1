package io.altar.stateMachine.jseproject.services;

import java.util.Collection;

import io.altar.stateMachine.jseproject.model.Product;
import io.altar.stateMachine.jseproject.repositories.ProductRepository;


public class ProductServices {
	
	private static final ProductRepository productRepository1= ProductRepository.getInstance();
	
	
	public static void createProduct(Product product1) {
		
		productRepository1.saveId(product1);
	}

	public static Collection<Product> consultAllProduct() {
		
		return productRepository1.consultAll();
	}
	
	
	public static void removeProduct(Long id) {
		productRepository1.removeById(id);
		
	}
	public static Product consultByIdProduct(Long id) {
		return productRepository1.consultById(id);
	}

}
