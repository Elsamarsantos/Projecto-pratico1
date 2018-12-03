package io.altar.stateMachine.jseproject.textInterface.states;

import io.altar.stateMachine.jseproject.model.Product;
import io.altar.stateMachine.jseproject.model.Shelf;
import io.altar.stateMachine.jseproject.repositories.ProductRepository;
import io.altar.stateMachine.jseproject.repositories.ShelfRepository;
import io.altar.stateMachine.jseproject.services.ProductServices;
import io.altar.stateMachine.jseproject.services.ShelfServices;

public class EditShelf implements States{
	
	

	
	
	@Override
	public int execute() {
		Shelf shelfToEdited = scannerUtils.getShelfById("Qual o Id da prateleira a alterar",true);
		
		int capacidade= scannerUtils.getIntScanner("novo valor de capacidade", true);
		if(capacidade!=-1) {
			shelfToEdited.setCapacidade(capacidade);
		}
		
		double precoAluguer = scannerUtils.getIntScanner("novo valor de preco do Aluguer", true);
		if(precoAluguer!=-1) {
			shelfToEdited.setPrecoAluguer(precoAluguer);
		}
		
		
		//alterar o product da prateleira

	
		Product productId = scannerUtils.getProductById("novo produto na prateleira",true);
		
		if(productId !=null) {
			
			Long idProduct = productId.getId();
			Product productToChange = shelfToEdited.getProdutoAlberga();
			
			if(productToChange!=null) {
			productToChange.removeShelf(shelfToEdited);
			}
			
			Product productIdNew = ProductServices.consultByIdProduct(idProduct);	
			shelfToEdited.setProdutoAlberga(productIdNew);
			productIdNew.addToListShelves(shelfToEdited);

		}
		
		
		return 1;
	}

}
