package io.altar.jseproject.textinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class TextInterface {
	
	ProductRepository productRepository1 = ProductRepository.getInstance();
	ShelfRepository shelfRepository1 = ShelfRepository.getInstance();
	ScannerUtils scannerUtils = new ScannerUtils();
	 

// menu inicial 
	public void menuInicial() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1) Listar produtos");
		System.out.println("2) Listar prateleiras");
		System.out.println("3) Sair");
		System.out.println("Escolha a opcao:");
		char opcao = sc.next().charAt(0);
		sc.nextLine();
		if (opcao == '1') {
			menuListarProdutos();

		} else if (opcao == '2') {
			menuListarPrateleiras();
		
		}else if (opcao == '3') {
			System.out.println("Sair");

		}else {
			System.out.println("erro:escolha so opcao 1, 2 ou 3");
			menuInicial();
		}
		
		sc.close();
		

	}
	
// metodo para voltar aos menus
	private void menus() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Menus: 1-inicial 2-Produtos 3-Prateleiras ");
		char opcao= sc.nextLine().charAt(0);
		
		switch (opcao) {
		case '2':
			menuListarProdutos();
				
			break;
		case '1':
			menuInicial();
			
			break;
		case '3':
			menuListarPrateleiras();
			
			break;

		default:menuInicial();
		break;
		}
		sc.close();
		
	}
	
//menu de produtos
	private void menuListarProdutos() {
		
	//lista dos produtos existentes
		System.out.println("Lista de Produtos:");
		Iterator<Product> productlist = productRepository1.consultAll().iterator();
		while (productlist.hasNext()){

			System.out.println(productlist.next());
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1) Criar novo produtos");
		System.out.println("2) Editar um produto existente");
		System.out.println("3) Consultar o detalhe de um produto");
		System.out.println("4) Remover um produto");
		System.out.println("5) Voltar ao ecra anterior");
		System.out.println("Escolha a opcao:");

		char opcao = sc.next().charAt(0);
		sc.nextLine();
		
		switch(opcao) {
		case '1':
			System.out.println("Criar novo produto");
			newProduct();
			
			break;
		case '2':
			System.out.println("Editar um produto existente");
			editProduct();
			break;
		case '3':
			System.out.println("Consultar o detalhe de um produto");
			consultProduct ();
			break;
		case '4':
			System.out.println("Remover um produto");
			removeProduct();
			break;
		case '5':
			menuInicial();
			break;
		default: 	
			System.out.println("erro:escolha so opcao 1, 2, 3, 4 ou 5");
			menuListarProdutos();
			break;
		
		
		}
		sc.close();

	}


// menu criar produto	
	
	public void newProduct() {
	
		double valorDesconto = scannerUtils.getValidDoubleScanner("colocar o valor de desconto:",100);
		double iva = scannerUtils.getValidDoubleScanner("colocar o valor do iva:",100);
		double pvp = scannerUtils.getDoubleScanner("colocar o valor do pvp:");
		
		Product product1= new Product(valorDesconto, iva, pvp);
		productRepository1.saveId(product1);
	
		System.out.println("novo producto: "+ product1.toString());
	
		menuInicial();
		
	}
	
// comeca o editar produto	
	
	private void editProduct() {

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
					
			System.out.println("novo producto: "+ productToBeEdited.toString());
	
		menus();
	}




//menu de consultar produto

	private void consultProduct () {
		Product productToBeConsult = scannerUtils.getProductById("Coloque o id do produto a consultar",true);
		System.out.println("Produto: "+ productToBeConsult.toString());
		menus();

	}
	
//menu remover produto
	private void removeProduct() {

		Product consultProduct = scannerUtils.getProductById("Coloque o id do produto a editar",true);
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
			menus();
			break;

		case 'n':
			menus();
			break;
		default:menus();
		break;

		}
		menus();

	}

/*menu de prateleiras */
	
	//lista das prateleiras
	private  void menuListarPrateleiras() {
		System.out.println("Lista de Shelfs:");
		Iterator <Shelf> shelfList = shelfRepository1.consultAll().iterator();
		
		while(shelfList.hasNext()) {
			System.out.println(shelfList.next());
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1) Criar nova prateleira");
		System.out.println("2) Editar prateleira existente");
		System.out.println("3) Consultar o detalhe da prateleria");
		System.out.println("4) Remover prateleira");
		System.out.println("5) Voltar ao ecra anterior");
		System.out.println("Escolha a opcao:");

		char opcao = sc.nextLine().charAt(0);

		switch(opcao) {
		case '1':
			System.out.println("Criar nova prateleira");
			newShelf();
			break;
		case '2':
			System.out.println("Editar prateleira existente");
			editShelf();
			break;
		case '3':
			System.out.println("Consultar o detalhe da prateleira");
			consultShelf();
			break;
		case '4':
			System.out.println("Remover prateleira");
			removeShelf();
			break;
		case '5':
			menuInicial();break;
		default: 	
			System.out.println("erro:escolha so opcao 1, 2, 3, 4 ou 5");
			menuListarProdutos();
			break;


		}
		sc.close();
	}
//criar novas prateleiras
	private void newShelf() {
		
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

		menus();
		sc.close();
		
		
	}
//editar prateleira
	
	private void editShelf() {
				
		Scanner sc= new Scanner (System.in);
		System.out.println("Qual o Id da prateleira a alterar");
		long id = sc.nextLong();
		sc.nextLine();
		
		
		if(shelfRepository1.consultById(id)!=null) {
			Shelf shelfToEdited = shelfRepository1.consultById(id);
			
			int capacidade= scannerUtils.getIntScanner("novo valor de capacidade", true);
			if(capacidade!=-1) {
				shelfToEdited.setCapacidade(capacidade);
			}
			
			
			//alterar o product da prateleira
			System.out.println("novo produto na prateleira");
			String productId = sc.nextLine();

			if(productId.length()!=0) {

				Product productToChange = shelfToEdited.getProdutoAlberga();
				if(productToChange!=null) {
				productToChange.removeShelf(shelfToEdited);
				}
				shelfToEdited.getPrecoAluguer();
				Long product2 = Long.parseLong(productId);
				Product productIdNew = productRepository1.consultById(product2);
				shelfToEdited.setProdutoAlberga(productIdNew);
				productIdNew.addToListShelves(shelfToEdited);


			}

			double precoAluguer = scannerUtils.getIntScanner("novo valor de preco do Aluguer", true);
			if(precoAluguer!=-1) {
				shelfToEdited.setPrecoAluguer(precoAluguer);
			}
			
			
		}else {
			System.out.println("Esse Id de Shelf nao existe!!!");
			editShelf();

		}
		menus();
		sc.close();

	}
//consulta prateleiras
	private void consultShelf() {
						
		Scanner sc= new Scanner(System.in);
		System.out.println("Coloque o id da prateleira a pesquisar ");
		long id= sc.nextLong();;
		sc.nextLine();
		
		if(shelfRepository1.consultById(id)!=null) {
			Shelf shelfconsult = shelfRepository1.consultById(id);
			System.out.println("Shelf: " + shelfconsult.toString());
			
		}else {
			System.out.println("Essa shelf nao existe");
			
		}
		menus();
		sc.close();
		
	}

//remover prateleiras
	private void removeShelf() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Coloque o id da shelf a remover ");
		long id = sc.nextLong();
		sc.nextLine();
		if(shelfRepository1.consultById(id)!=null) {	
			Shelf shelfconsult = shelfRepository1.consultById(id);
			Product productToRemove = shelfconsult.getProdutoAlberga();
			System.out.println("ver:"+productToRemove);
			Iterator<Shelf> shelflist = productToRemove.getListShelfIn().iterator();
			
			System.out.println("A Shelf a remover e esta: " + shelfconsult.toString());
			System.out.println("Quer remover? y ou n");
			char remove = Character.toLowerCase(sc.next().charAt(0));
			sc.nextLine();
			switch (remove) {
			case 'y':
								
				if(shelfconsult.getProdutoAlberga()!=null) {
				while(shelflist.hasNext()) {
					productToRemove.removeShelf(shelflist.next());
					
				}
				
				}
				shelfRepository1.removeById(id);
				System.out.println("foi removida a shelf.");
				menus();
				break;

			case 'n':
				menus();
				break;

			default:menus();
			break;
			}
			sc.close();
			
		}else {
			System.out.println("Esse id nao existe!!!");
			
		}
		menus();
		sc.close();
		
	}


}

