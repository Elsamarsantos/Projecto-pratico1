package io.altar.repository;

import io.altar.model.Shelf;

public class ShelfRepository extends EntityRepository<Shelf>{
	private static final ShelfRepository INSTANCE = new ShelfRepository();

	private ShelfRepository() {}

	public static ShelfRepository getInstance() {

		return INSTANCE;
	}

}
