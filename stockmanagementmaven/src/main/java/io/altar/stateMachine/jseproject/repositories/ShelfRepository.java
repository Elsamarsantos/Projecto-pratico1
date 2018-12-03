package io.altar.stateMachine.jseproject.repositories;

import io.altar.stateMachine.jseproject.model.Shelf;

public class ShelfRepository extends EntityRepository<Shelf>{
	
	
	private static final ShelfRepository INSTANCE = new ShelfRepository();

	private ShelfRepository() {}

	public static ShelfRepository getInstance() {

		return INSTANCE;
	}
	
}
