package io.altar.stateMachine.jseproject.textInterface.states;

import io.altar.stateMachine.jseproject.model.Product;

public class ConsultProduct implements States {
	
	public int execute() {
		
		Product productToBeConsult = scannerUtils.getProductById("Coloque o id do produto a consultar",true);
		if (productToBeConsult!=null) {
		System.out.println("Produto: "+ productToBeConsult.toString());

		}
		else {
			System.out.println("Esse produto nao existe");
		}
		return 1;
	}
	

}
