package io.altar.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import io.altar.dto.ProductDto;
import io.altar.dto.ShelfDto;
import io.altar.model.Product;
import io.altar.model.Shelf;
import io.altar.repository.ProductRepository;
import io.altar.repository.ShelfRepository;

public class ProductBusiness {

	private static final ProductRepository productRepository1 = ProductRepository.getInstance();
	private static final ShelfRepository shelfRepository1 = ShelfRepository.getInstance();

	public void createProduct(Product product1) {

		Iterator<Shelf> listShelfInProduct = product1.getListShelfIn().iterator();

		Shelf shelfToAdd;

		while (listShelfInProduct.hasNext()) {
			
			Shelf shelf1=listShelfInProduct.next();
			shelfToAdd = shelfRepository1.consultById(shelf1.getId());
			if (shelfToAdd != null && shelfToAdd.getProdutoAlberga() == null) {
				shelfToAdd.setProdutoAlberga(product1);
			} else  {
				product1.removeShelf(shelf1);
				listShelfInProduct = product1.getListShelfIn().iterator();
			}
		}

		productRepository1.saveId(product1);
	
	}


	
	
	public List <ProductDto> consultAllProduct() {
		
		Collection<Product> allProducts = productRepository1.consultAll();
		
		
		List <ProductDto> allProductsDto = new ArrayList();
		
		for(Product product1: allProducts ) {
			
			ProductDto productDto = new ProductDto(product1.getId(),product1.getValorDesconto(),product1.getIva(),product1.getPvp());
			allProductsDto.add(productDto);
		}
		
		
		return allProductsDto;
				
	
		
	}
	

	public void removeProduct(Long id) {

		Product productToRemove = productRepository1.consultById(id);

		if (productToRemove != null) {
			Iterator<Shelf> shelfList = productToRemove.getListShelfIn().iterator();
			while (shelfList.hasNext()) {
				Shelf shelf1 = shelfRepository1.consultById(shelfList.next().getId());
				shelf1.setProdutoAlberga(null);

			}
			productRepository1.removeById(id);
		}

	}

	public ProductDto consultByIdProduct(Long id) {
		
		Product product1 = productRepository1.consultById(id);
		
		ProductDto productDto = new ProductDto(product1.getId(),product1.getValorDesconto(),product1.getIva(),product1.getPvp());
		
		
		return productDto;
	}

	public void editProductByID(Product product1) {


		if(productRepository1.consultById(product1.getId())!=null) {

			Product oldProduct =productRepository1.consultById(product1.getId()); //este � o id do produto

			//vai eliminar as prateleiras que tiverem respectivo este id producto 
			Iterator<Shelf> listShelfInProductToRemove = oldProduct.getListShelfIn().iterator();

			while (listShelfInProductToRemove.hasNext()) {

				shelfRepository1.consultById(listShelfInProductToRemove.next().getId()).setProdutoAlberga(null);

			}


			//editar a lista das prateliras onde o produto esta
			Iterator<Shelf> listShelfInProduct = product1.getListShelfIn().iterator();

			Shelf shelfToAdd;

			while (listShelfInProduct.hasNext()) {
				Shelf shelf1=listShelfInProduct.next();
				shelfToAdd = shelfRepository1.consultById(shelf1.getId());
				if (shelfToAdd != null && shelfToAdd.getProdutoAlberga() == null) {
					shelfToAdd.setProdutoAlberga(product1);
				} else  {
					product1.removeShelf(shelf1);
					listShelfInProduct = product1.getListShelfIn().iterator();
				}
			}
			productRepository1.editById(product1);
		}
	}
	
	public List<ShelfDto> listShelfInProduct(Long id){

		Product product1 = productRepository1.consultById(id);

		List<Shelf> listShelfInProduct = product1.getListShelfIn();


		List<ShelfDto> lst = new ArrayList();

		for(Shelf shelf1:listShelfInProduct) {
			
			lst.add(new ShelfDto(shelf1.getId(),shelf1.getCapacidade(),shelf1.getPrecoAluguer()));


		}

		return lst;


		
		
	}
	
	
}
