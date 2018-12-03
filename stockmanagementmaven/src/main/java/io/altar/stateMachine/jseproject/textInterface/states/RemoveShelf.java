package io.altar.stateMachine.jseproject.textInterface.states;

import java.util.Iterator;
import java.util.Scanner;

import io.altar.stateMachine.jseproject.model.Product;
import io.altar.stateMachine.jseproject.model.Shelf;
import io.altar.stateMachine.jseproject.repositories.ShelfRepository;
import io.altar.stateMachine.jseproject.services.ShelfServices;

public class RemoveShelf implements States {
	

	@Override
	public int execute() {


		Shelf shelfconsult = scannerUtils.getShelfById("Coloque o id da Shelf", true);

		Product productToRemove = shelfconsult.getProdutoAlberga();
		System.out.println("ver:"+productToRemove);
		Iterator<Shelf> shelflist = productToRemove.getListShelfIn().iterator();

		System.out.println("A Shelf a remover e esta: " + shelfconsult.toString());
		boolean toremove = scannerUtils.toYesOrNo("Quer remover? y ou n");

		if(toremove==true) {

			if(shelfconsult.getProdutoAlberga()!=null) {
				while(shelflist.hasNext()) {
					productToRemove.removeShelf(shelflist.next());
				}

			}

			ShelfServices.toRemoveShelf(shelfconsult.getId());
			System.out.println("foi removida a shelf.");

		}


		return 1;
	}

}
