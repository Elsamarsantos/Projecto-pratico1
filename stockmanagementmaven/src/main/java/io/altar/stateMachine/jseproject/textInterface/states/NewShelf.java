package io.altar.stateMachine.jseproject.textInterface.states;

import java.util.Scanner;

import io.altar.stateMachine.jseproject.model.Product;
import io.altar.stateMachine.jseproject.model.Shelf;
import io.altar.stateMachine.jseproject.services.ShelfServices;


public class NewShelf implements States {
	


	@Override
	public int execute() {
		int capacidade =scannerUtils.getIntScanner("Coloque o valor de capacidade");		
		double precoAluguer=scannerUtils.getDoubleScanner("Colocque o preco do Aluger");
		
		Product idProduct=null;
		idProduct=scannerUtils.getProductById("Qual o id do produto, caso nao queira carregue Enter", true);
	
		Shelf shelf1= new Shelf(capacidade, idProduct, precoAluguer);
		ShelfServices.createShelf(shelf1);
		
		if(idProduct != null){
		idProduct.addToListShelves(shelf1);	
		}
		
		System.out.println(shelf1.toString());

		return 1;
	}

}
