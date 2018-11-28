package io.altar.stateMachine.jseproject.textInterface.states;

import java.util.Scanner;

import io.altar.stateMachine.jseproject.model.Product;
import io.altar.stateMachine.jseproject.model.Shelf;
import io.altar.stateMachine.jseproject.repositories.ProductRepository;
import io.altar.stateMachine.jseproject.repositories.ShelfRepository;




public class NewShelf implements States {

	ShelfRepository shelfRepository1 = ShelfRepository.getInstance();
	ProductRepository productRepository1= ProductRepository.getInstance();
	
	@Override
	public int execute() {
		int capacidade =scannerUtils.getIntScanner("Coloque o valor de capacidade");		
		double precoAluguer=scannerUtils.getDoubleScanner("Colocque o preco do Aluger");
		
		Product idProduct=null;
		Scanner sc = new Scanner(System.in);
		System.out.println("colocar o produto que alberga");
		System.out.println("Caso nao queira colocar, carregue no Enter");
		String id = sc.nextLine();

		if(id.length()!=0) {

			long ids = Long.parseLong(id);
			if(productRepository1.consultById(ids)!=null) {
				idProduct = productRepository1.consultById(ids);

			} 
			else {

				System.out.println("esse id de produto nao existe");
				sc.nextLine();

			}
		}



		Shelf shelf1= new Shelf(capacidade, idProduct, precoAluguer);
		shelfRepository1.saveId(shelf1);
		
		if(idProduct != null){
		idProduct.addToListShelves(shelf1);	
		}
		
		System.out.println(shelf1.toString());

		return 2;
	}

}
