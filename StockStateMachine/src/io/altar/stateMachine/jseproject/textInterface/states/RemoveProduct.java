package io.altar.stateMachine.jseproject.textInterface.states;

import java.util.Iterator;
import java.util.Scanner;

import io.altar.stateMachine.jseproject.model.Product;
import io.altar.stateMachine.jseproject.model.Shelf;
import io.altar.stateMachine.jseproject.repositories.ProductRepository;



public class RemoveProduct implements States {
	ProductRepository productRepository1= ProductRepository.getInstance();
	@Override
	public int execute() {

		Product consultProduct = scannerUtils.getProductById("Coloque o id do produto a remover",true);
		
			System.out.println("prateleiras existente no produto"+consultProduct.getListShelfIn());

			Iterator<Shelf> shelfList = consultProduct.getListShelfIn().iterator();

			System.out.println("o produto a remover e este: " + consultProduct.toString());
			System.out.println("Quer remover? y ou n");
			Scanner sc = new Scanner(System.in);
			char remove = Character.toLowerCase(sc.nextLine().charAt(0));

			switch (remove) {
			case 'y':
				while (shelfList.hasNext()){

					shelfList.next().setProdutoAlberga(null);
				}
				productRepository1.removeById(consultProduct.getId());

				System.out.println("foi removido o produto.");

				break;

			case 'n':
				return 1;



			
		}

		return 1;
	}

}
