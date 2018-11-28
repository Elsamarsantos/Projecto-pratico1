package io.altar.stateMachine.jseproject.repositories;

import io.altar.stateMachine.jseproject.model.Product;

public class ProductRepository extends EntityRepository<Product> {


	private static final ProductRepository INSTANCE = new ProductRepository();

	private ProductRepository() {}

	public static ProductRepository getInstance() {

		return INSTANCE;
	}
	
	
}