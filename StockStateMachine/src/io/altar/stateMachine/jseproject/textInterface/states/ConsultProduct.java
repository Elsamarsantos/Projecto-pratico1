package io.altar.stateMachine.jseproject.textInterface.states;

import io.altar.stateMachine.jseproject.model.Product;

public class ConsultProduct implements States {
	
	public int execute() {
		
		Product productToBeConsult = scannerUtils.getProductById("Coloque o id do produto a consultar",true);		
		System.out.println("Produto: "+ productToBeConsult.toString());

		return 1;
	}
	

}
