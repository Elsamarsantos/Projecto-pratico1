package io.altar.stateMachine.jseproject.services;

import io.altar.stateMachine.jseproject.model.Shelf;
import io.altar.stateMachine.jseproject.repositories.ShelfRepository;

public class ShelfServices {
	ShelfRepository shelfRepository1 = ShelfRepository.getInstance();
	
	
	
	public void createShelf(Shelf shelf1) {
		
		shelfRepository1.saveId(shelf1);
	}
}
