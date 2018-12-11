package io.altar.repository;

import io.altar.model.Product;

public class ProductRepository extends EntityRepository<Product> {
	
	private static final ProductRepository INSTANCE = new ProductRepository();

	private ProductRepository() {}

	public static ProductRepository getInstance() {

		return INSTANCE;
	}
	
	
	
}
