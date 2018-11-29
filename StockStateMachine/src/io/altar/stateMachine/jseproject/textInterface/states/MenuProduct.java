package io.altar.stateMachine.jseproject.textInterface.states;

import java.util.Iterator;


import io.altar.stateMachine.jseproject.model.Product;
import io.altar.stateMachine.jseproject.repositories.ProductRepository;
import io.altar.stateMachine.jseproject.services.ProductServices;



public class MenuProduct implements States {
	
	
	
	@Override
	public int execute() {
		// TODO Auto-generated method stub
		System.out.println("Lista de Produtos:");
		Iterator<Product> productlist = ProductServices.consultAllProduct().iterator();
		while (productlist.hasNext()){

			System.out.println(productlist.next());
		}
		System.out.println("1) Criar novo produtos");
		System.out.println("2) Editar um produto existente");
		System.out.println("3) Consultar o detalhe de um produto");
		System.out.println("4) Remover um produto");
		System.out.println("5) Voltar ao ecra anterior");

		int [] opcao= {1,2,3,4,5};
		
		return scannerUtils.getValidIntFromScanner("Escolha a opcao:", opcao);
	}

}
