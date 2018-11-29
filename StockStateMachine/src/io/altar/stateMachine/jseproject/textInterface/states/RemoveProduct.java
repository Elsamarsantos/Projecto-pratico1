package io.altar.stateMachine.jseproject.textInterface.states;

import java.util.Iterator;
import java.util.Scanner;

import io.altar.stateMachine.jseproject.model.Product;
import io.altar.stateMachine.jseproject.model.Shelf;
import io.altar.stateMachine.jseproject.repositories.ProductRepository;
import io.altar.stateMachine.jseproject.services.ProductServices;



public class RemoveProduct implements States {
	

	
	
	@Override
	public int execute() {

		Product consultProduct1 = scannerUtils.getProductById("Coloque o id do produto a remover",true);

		System.out.println("prateleiras existente no produto"+consultProduct1.getListShelfIn());

		Iterator<Shelf> shelfList = consultProduct1.getListShelfIn().iterator();

		System.out.println("o produto a remover e este: " + consultProduct1.toString());

		boolean toRemove = scannerUtils.toYesOrNo("Quer remover? y ou n");
		if (toRemove ==true) {
			while (shelfList.hasNext()){
				shelfList.next().setProdutoAlberga(null);
			}

			ProductServices.removeProduct(consultProduct1.getId());
			System.out.println("foi removido o produto.");
		}

		return 1;
	}

}
