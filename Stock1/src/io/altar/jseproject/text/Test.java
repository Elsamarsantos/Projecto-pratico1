package io.altar.jseproject.text;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;
import io.altar.jseproject.textinterface.TextInterface;

public class Test {
	static ProductRepository productRepository1 = ProductRepository.getInstance();
	static ShelfRepository shelfRepository1 = ShelfRepository.getInstance();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextInterface menuinicial = new TextInterface();
		
		createEntities();
		menuinicial.menuInicial();
		
	}
	

	public static void createEntities() {
		
		
		Product product1 = new Product(1,1,1);
		Product product2 = new Product(2,2,2);
		Product product3 = new Product(3,3,3);
		
		
		productRepository1.saveId(product1);
		productRepository1.saveId(product2);
		productRepository1.saveId(product3);
		
		
	
	}
	
	

}
