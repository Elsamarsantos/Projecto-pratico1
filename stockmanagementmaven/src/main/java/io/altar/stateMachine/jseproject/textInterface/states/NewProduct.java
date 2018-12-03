package io.altar.stateMachine.jseproject.textInterface.states;


import io.altar.stateMachine.jseproject.model.Product;
import io.altar.stateMachine.jseproject.repositories.ProductRepository;
import io.altar.stateMachine.jseproject.services.ProductServices;

public class NewProduct implements States {
	
	

	@Override
	public int execute() {
		
		// TODO Auto-generated method stub
		double valorDesconto = scannerUtils.getValidDoubleScanner("colocar o valor de desconto:",100);
		double iva = scannerUtils.getValidDoubleScanner("colocar o valor do iva:",100);
		double pvp = scannerUtils.getDoubleScanner("colocar o valor do pvp:");
		
		Product product1= new Product(valorDesconto, iva, pvp);
		ProductServices.createProduct(product1);
		
		
		
		return 1;
	}

}
