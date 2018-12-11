package io.altar.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.altar.dto.ShelfDto;
import io.altar.model.Product;
import io.altar.model.Shelf;
import io.altar.repository.ProductRepository;
import io.altar.repository.ShelfRepository;

public class ShelfBusiness {
	private static final ShelfRepository shelfRepository1 = ShelfRepository.getInstance();
	private static final ProductRepository productRepository1= ProductRepository.getInstance();
	

	
	public void createShelf(Shelf shelf1) {

		Product productInShelf=productRepository1.consultById(shelf1.getProdutoAlberga().getId());
				
		if (productInShelf !=null) {
			shelf1.setProdutoAlberga(productInShelf);						
			shelfRepository1.saveId(shelf1);
			productInShelf.addToListShelves(shelf1);
		}else {

			Product productInShelf2= null;
			shelf1.setProdutoAlberga(productInShelf2);
			shelfRepository1.saveId(shelf1);

		}


	}
	
	public List <ShelfDto> consultAllShelf(){
		
		
		Collection <Shelf> shelfList = shelfRepository1.consultAll();
		List <ShelfDto> shelfListDto = new ArrayList();
		for(Shelf shelf1:shelfList ) {
			shelfListDto.add(new ShelfDto(shelf1.getId(),shelf1.getCapacidade(),shelf1.getProdutoAlberga(),shelf1.getPrecoAluguer()));
			
			
		}
		
		
		return shelfListDto;
		
	}
	
	public void toRemoveShelf(Long id) {

		Shelf shelf1 = shelfRepository1.consultById(id);
		if (shelf1!=null) {
			Product productToRemove = productRepository1.consultById(shelf1.getProdutoAlberga().getId());
			productToRemove.removeShelf(shelf1);

			shelfRepository1.removeById(id);
		}
	}
	public ShelfDto consultShelf(Long id) {
		
		Shelf shelf1=shelfRepository1.consultById(id);
		ShelfDto shelfDto= new ShelfDto(shelf1.getId(),shelf1.getCapacidade(),shelf1.getProdutoAlberga(),shelf1.getPrecoAluguer());

		return shelfDto;

	}
	
	public void toeditShelf(Shelf shelf1) {
		
		
		if(shelf1.getId()!=null) { //verifica se existe a shelf

			Product newProductInShelf=productRepository1.consultById(shelf1.getProdutoAlberga().getId());//vai buscar o produto pelo id introduzido

			Shelf shelfToEdit = shelfRepository1.consultById(shelf1.getId());
			Product oldProductInShelf = productRepository1.consultById(shelfToEdit.getProdutoAlberga().getId());
			
			
			if (newProductInShelf !=null) { //se existir este produto entao vai editar a prateleira
			
				oldProductInShelf.removeShelf(shelf1);

				shelf1.setProdutoAlberga(newProductInShelf);	//vai colocar o produto na prateleira	
				shelfRepository1.editById(shelf1);
				newProductInShelf.addToListShelves(shelf1); //vai colocar a prateleira no produto

				
				
			}else {

				shelf1.setProdutoAlberga(oldProductInShelf);
				shelfRepository1.editById(shelf1);

			}

		}

	}
	
}