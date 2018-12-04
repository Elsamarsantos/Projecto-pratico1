package io.altar.jseproject.services;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.jseproject.business.ProductServices;
import io.altar.jseproject.model.Product;



@Path("/stock")
public class TextInterface {
	
	@GET
	@Path("/health")
	@Produces(MediaType.TEXT_PLAIN)
	private String health() {
		return "Api is working";
	}

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	private String health2() {
		return "Api is working";
	}

// menu criar produto	
	
	@POST
	@Consumes("applicaton/json")
	@Produces("applicaton/json")
	public Product newProduct(Product product1) {
		
		System.out.println("Chegou: "+product1.getPvp());

		ProductServices.createProduct(product1);
		
		return product1;
	
	}

	
// comeca o editar produto	

	@PUT
	@Path ("/{id}")
	@Consumes("applicaton/json")
	@Produces("applicaton/json")
	public Product editProduct(@PathParam("id") long id, Product product1) {

		product1= ProductServices.consultByIdProduct(id);
		
		ProductServices.editProduct(product1);	
		
		return product1;

		
	}
	




//menu de consultar produto

	@GET
	@Path("/{id}")
	@Produces("applicaton/json")
	
	private Product consultProduct (@PathParam("id") long id, Product product1) {
		
		product1 = ProductServices.consultByIdProduct(id);
		return product1;
		

	}
}
//	
////menu remover produto
//	private void removeProduct() {
//
//		Product consultProduct = scannerUtils.getProductById("Coloque o id do produto a remover",true);
//		if (consultProduct==null) {
//			System.out.println("Esse produto nao existe");
//		}else {
//		
//			System.out.println("prateleiras existente no produto"+consultProduct.getListShelfIn());
//		
//		Iterator<Shelf> shelfList = consultProduct.getListShelfIn().iterator();
//
//		System.out.println("o produto a remover e este: " + consultProduct.toString());
//		System.out.println("Quer remover? y ou n");
//		Scanner sc = new Scanner(System.in);
//		char remove = Character.toLowerCase(sc.nextLine().charAt(0));
//
//		switch (remove) {
//		case 'y':
//			while (shelfList.hasNext()){
//
//				shelfList.next().setProdutoAlberga(null);
//			}
//			ProductServices.removeProduct(consultProduct.getId());
//
//			System.out.println("foi removido o produto.");
//			menuListarProdutos();
//			break;
//
//		case 'n':
//			menuListarProdutos();
//			break;
//		
//
//		}
//		}
//		menuListarProdutos();vvv
//
//	}
//
///*menu de prateleiras */
//	
//	//lista das prateleiras
//	private  void menuListarPrateleiras() {
//		System.out.println("Lista de Shelfs:");
//		Iterator <Shelf> shelfList = ShelfServices.consultAllShelf().iterator();
//		
//		while(shelfList.hasNext()) {
//			System.out.println(shelfList.next());
//		}
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("1) Criar nova prateleira");
//		System.out.println("2) Editar prateleira existente");
//		System.out.println("3) Consultar o detalhe da prateleria");
//		System.out.println("4) Remover prateleira");
//		System.out.println("5) Voltar ao ecra anterior");
//		System.out.println("Escolha a opcao:");
//
//		char opcao = sc.nextLine().charAt(0);
//
//		switch(opcao) {
//		case '1':
//			System.out.println("Criar nova prateleira");
//			newShelf();
//			break;
//		case '2':
//			System.out.println("Editar prateleira existente");
//			editShelf();
//			break;
//		case '3':
//			System.out.println("Consultar o detalhe da prateleira");
//			consultShelf();
//			break;
//		case '4':
//			System.out.println("Remover prateleira");
//			removeShelf();
//			break;
//		case '5':
//			menuInicial();break;
//		default: 	
//			System.out.println("erro:escolha so opcao 1, 2, 3, 4 ou 5");
//			menuListarPrateleiras();
//			break;
//
//
//		}
//		sc.close();
//	}
////criar novas prateleiras
//	private void newShelf() {
//		
//		int capacidade =scannerUtils.getIntScanner("Coloque o valor de capacidade");		
//		double precoAluguer=scannerUtils.getDoubleScanner("Colocque o preco do Aluger");
//		
//		Product idProduct=null;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("colocar o produto que alberga");
//		System.out.println("Caso nao queira colocar, carregue no Enter");
//		String id = sc.nextLine();
//
//		if(id.length()!=0) {
//
//			long ids = Long.parseLong(id);
//			if(productRepository1.consultById(ids)!=null) {
//				idProduct = productRepository1.consultById(ids);
//
//			} 
//			else {
//
//				System.out.println("esse id de produto nao existe");
//				sc.nextLine();
//
//			}
//		}
//
//
//
//		Shelf shelf1= new Shelf(capacidade, idProduct, precoAluguer);
//		shelfRepository1.saveId(shelf1);
//		
//		if(idProduct != null){
//		idProduct.addToListShelves(shelf1);	
//		}
//		
//		System.out.println(shelf1.toString());
//
//		menuListarPrateleiras();
//		sc.close();
//		
//		
//	}
////editar prateleira
//	
//	private void editShelf() {
//		
//		
//			Shelf shelfToEdited = scannerUtils.getShelfById("Qual o Id da prateleira a alterar",true);
//			
//			int capacidade= scannerUtils.getIntScanner("novo valor de capacidade", true);
//			if(capacidade!=-1) {
//				shelfToEdited.setCapacidade(capacidade);
//			}
//			
//			
//			//alterar o product da prateleira
//
//		
//			Product productId = scannerUtils.getProductById("novo produto na prateleira",true);
//			
//			if(productId !=null) {
//				
//				Long idProduct = productId.getId();
//				Product productToChange = shelfToEdited.getProdutoAlberga();
//				
//				if(productToChange!=null) {
//				productToChange.removeShelf(shelfToEdited);
//				}
//				//shelfToEdited.getPrecoAluguer();
//				
//				
//				Product productIdNew = productRepository1.consultById(idProduct);
//				shelfToEdited.setProdutoAlberga(productIdNew);
//				productIdNew.addToListShelves(shelfToEdited);
//
//
//			}
//			
//
//			double precoAluguer = scannerUtils.getIntScanner("novo valor de preco do Aluguer", true);
//			if(precoAluguer!=-1) {
//				shelfToEdited.setPrecoAluguer(precoAluguer);
//			}
//			
//			
//		
//
//		
//			menuListarPrateleiras();
//		
//
//	}
////consulta prateleiras
//	private void consultShelf() {
//						
//		Shelf shelfconsult= scannerUtils.getShelfById("Coloque o id da Shelf", true);
////		if (shelfconsult==null) {
////			System.out.println("Esse produto nao existe");
////		}else {
//			System.out.println("Shelf: " + shelfconsult.toString());
//	//	}
//			
//			menuListarPrateleiras();
//		
//		
//	}
//
////remover prateleiras
//	private void removeShelf() {
//		
//		Shelf shelfconsult = scannerUtils.getShelfById("Coloque o id da Shelf", true);
//
//		Product productToRemove = shelfconsult.getProdutoAlberga();
//		System.out.println("ver:"+productToRemove);
//		Iterator<Shelf> shelflist = productToRemove.getListShelfIn().iterator();
//
//		System.out.println("A Shelf a remover e esta: " + shelfconsult.toString());
//		boolean toremove = scannerUtils.toYesOrNo("Quer remover? y ou n");
//
//		if(toremove==true) {
//
//			if(shelfconsult.getProdutoAlberga()!=null) {
//				while(shelflist.hasNext()) {
//					productToRemove.removeShelf(shelflist.next());
//				}
//
//			}
//
//			ShelfServices.toRemoveShelf(shelfconsult.getId());
//			System.out.println("foi removida a shelf.");
//
//		}
//		
//
//	
//		menuListarPrateleiras();
//	
//
//	}
//
//
//}
//
