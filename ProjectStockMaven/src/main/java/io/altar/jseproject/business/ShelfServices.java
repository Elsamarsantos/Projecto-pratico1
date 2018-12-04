package io.altar.jseproject.business;

import java.util.Collection;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;



public class ShelfServices {
	private static final ShelfRepository shelfRepository1 = ShelfRepository.getInstance();
	
	
	
	public static void createShelf(Shelf shelf1) {
		
		shelfRepository1.saveId(shelf1);
	}
	
	public static Collection <Shelf> consultAllShelf(){
		
		return shelfRepository1.consultAll();
		
	}
	
	public static void toRemoveShelf(Long id) {
		shelfRepository1.removeById(id);
		
	}
}