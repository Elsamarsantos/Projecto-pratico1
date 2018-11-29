package io.altar.stateMachine.jseproject.textInterface.states;

import java.util.Scanner;

import io.altar.stateMachine.jseproject.model.Product;
import io.altar.stateMachine.jseproject.model.Shelf;
import io.altar.stateMachine.jseproject.repositories.ProductRepository;
import io.altar.stateMachine.jseproject.repositories.ShelfRepository;
import io.altar.stateMachine.jseproject.services.ShelfServices;




public class NewShelf implements States {
	
	ShelfServices shelfServices = new ShelfServices();

	@Override
	public int execute() {
		int capacidade =scannerUtils.getIntScanner("Coloque o valor de capacidade");		
		double precoAluguer=scannerUtils.getDoubleScanner("Colocque o preco do Aluger");
		
		Product idProduct=null;
		if(scannerUtils.getProductById("Qual o id do produto, caso nao queira carrgue Enter", true)!=null) {

			idProduct =scannerUtils.getProductById("", true);
		} 

		Shelf shelf1= new Shelf(capacidade, idProduct, precoAluguer);
		shelfServices.createShelf(shelf1);
		
		if(idProduct != null){
		idProduct.addToListShelves(shelf1);	
		}
		
		System.out.println(shelf1.toString());

		return 1;
	}

}
