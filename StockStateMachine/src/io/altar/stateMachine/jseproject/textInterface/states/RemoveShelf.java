package io.altar.stateMachine.jseproject.textInterface.states;

import java.util.Iterator;
import java.util.Scanner;

import io.altar.stateMachine.jseproject.model.Product;
import io.altar.stateMachine.jseproject.model.Shelf;
import io.altar.stateMachine.jseproject.repositories.ShelfRepository;

public class RemoveShelf implements States {
	ShelfRepository shelfRepository1 = ShelfRepository.getInstance();

	@Override
	public int execute() {


		Shelf shelfconsult = scannerUtils.getShelfById("Coloque o id da Shelf", true);

		Product productToRemove = shelfconsult.getProdutoAlberga();
		System.out.println("ver:"+productToRemove);
		Iterator<Shelf> shelflist = productToRemove.getListShelfIn().iterator();

		System.out.println("A Shelf a remover e esta: " + shelfconsult.toString());
		System.out.println("Quer remover? y ou n");
		Scanner sc = new Scanner (System.in);
		char remove = Character.toLowerCase(sc.next().charAt(0));
		sc.nextLine();
		switch (remove) {
		case 'y':

			if(shelfconsult.getProdutoAlberga()!=null) {
				while(shelflist.hasNext()) {
					productToRemove.removeShelf(shelflist.next());
				}

			}
			shelfRepository1.removeById(shelfconsult.getId());
			System.out.println("foi removida a shelf.");
			break;

		case 'n':
			return 2;


		}
		sc.close();

		return 2;
	}

}
