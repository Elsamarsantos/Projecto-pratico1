package io.altar.stateMachine.jseproject.textInterface.states;

import java.util.Iterator;

import io.altar.stateMachine.jseproject.model.Shelf;
import io.altar.stateMachine.jseproject.services.ShelfServices;



public class MenuShelves implements States{
	ShelfServices shelfServices = new ShelfServices();
	
	@Override
	public int execute() {
		// TODO Auto-generated method stub
		System.out.println("Lista de Shelfs:");
		
		Iterator <Shelf> shelfList = shelfServices.consultAllShelf().iterator();

		while(shelfList.hasNext()) {
			System.out.println(shelfList.next());
		}
	
		System.out.println("1) Criar nova prateleira");
		System.out.println("2) Editar prateleira existente");
		System.out.println("3) Consultar o detalhe da prateleria");
		System.out.println("4) Remover prateleira");
		System.out.println("5) Voltar ao ecra anterior");
	
		int [] opcao= {1,2,3,4,5};
		return scannerUtils.getValidIntFromScanner("Escolha a opcao:", opcao);
	}
	

}
