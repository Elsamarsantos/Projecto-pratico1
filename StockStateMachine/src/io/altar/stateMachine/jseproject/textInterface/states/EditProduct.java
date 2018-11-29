package io.altar.stateMachine.jseproject.textInterface.states;

import java.util.Iterator;
import java.util.List;

import io.altar.stateMachine.jseproject.model.Product;
import io.altar.stateMachine.jseproject.model.Shelf;

public class EditProduct implements States{

	@Override
	public int execute() {

		Product productToBeEdited = scannerUtils.getProductById("Coloque o id do produto a editar",true);

		double valorDesconto = scannerUtils.getValidDoubleScanner("diga qual o valor do desconto", 100, true);
		if(valorDesconto!=-1) {
			productToBeEdited.setValorDesconto(valorDesconto);
		}

		double iva =scannerUtils.getValidDoubleScanner("diga qual o valor do iva", 100, true);
		if(iva!=-1) {
			productToBeEdited.setIva(iva);
		}
		
		double pvp =scannerUtils.getDoubleScanner("diga qual o valor do pvp", true);
		if(pvp!=-1) {
			productToBeEdited.setPvp(pvp);
		}
		
		
		Shelf shelfInAList = scannerUtils.getShelfById("Insira a prateleira", true);
		productToBeEdited.addToListShelves(shelfInAList);
		shelfInAList.setProdutoAlberga(productToBeEdited);
		

				
		System.out.println("novo producto: "+ productToBeEdited.toString());

		return 1;
	}

}
