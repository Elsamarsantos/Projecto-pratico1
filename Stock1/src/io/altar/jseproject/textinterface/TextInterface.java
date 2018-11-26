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
			System.out.println("1) Criar novo produtos");
			newProduct();
			
			break;
		case '2':
			System.out.println("2) Editar um produto existente");
			editProduct();
			break;
		case '3':
			System.out.println("3) Consultar o detalhe de um produto");
			consultProduct ();
			break;
		case '4':
			System.out.println("4) Remover um produto");
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


// menu o criar produto	
	
	public void newProduct() {
		
		double valorDesconto=0;
		double iva=0;
		double pvp=0;
		Scanner sc = new Scanner(System.in);
		
		boolean continueInput = true;
		do {
		try {
			System.out.println("colocar o valor de desconto:");
			valorDesconto = sc.nextDouble();
			sc.nextLine();
			continueInput = false;
		}catch (InputMismatchException ex) {
			System.out.println("Erro: coloque o valor correcto.");
			sc.nextLine();
		}
		} while (continueInput);
		
	
		boolean continueInput1 = true;
		do {
		try {
			System.out.println("colocar o valor do iva:");
			iva = sc.nextDouble();
			sc.nextLine();
			continueInput1 = false;
			
		}catch (InputMismatchException ex) {
			System.out.println("Erro: coloque o valor correcto.");
			sc.nextLine();
		}
		} while (continueInput1);
		
		boolean continueInput2 = true;
		do {
		try {
			System.out.println("colocar o valor do pvp:");
			pvp =sc.nextDouble(); 
			sc.nextLine();
			continueInput2 = false;
		}catch (InputMismatchException ex) {
			System.out.println("Erro: coloque o valor correcto.");
			sc.nextLine();
		}
		} while (continueInput2);
			
	
		
		Product product1= new Product(valorDesconto, iva, pvp);
		
		productRepository1.saveId(product1);
	
		System.out.println("novo producto: "+ product1.toString());
	    
		
		menuInicial();
		sc.close();
	}
	
// comeca o editar produto	
	
	private void editProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Colocar o id do produto:");
		Long id = sc.nextLong();
		sc.nextLine();

		//primeiro temos de saber se o produto existe

		if(productRepository1.consultById((long)id)!=null) {
			Product productToBeEdited = productRepository1.consultById((long)id);

			System.out.println("diga qual o valor do desconto");

			String valorDesconto = sc.nextLine();

			if(valorDesconto.length()==0) {
				double valorDescontoNew = productRepository1.consultById(id).getValorDesconto();
				productToBeEdited.setValorDesconto(valorDescontoNew);
			}
			else {	
				double valorDescontoNew= Double.parseDouble(valorDesconto);
				productToBeEdited.setValorDesconto(valorDescontoNew);
			}

			System.out.println("diga qual o valor do iva");
			String iva = sc.nextLine();

			if(iva.length()==0) {
				double ivaNew = productRepository1.consultById(id).getIva();
				productToBeEdited.setIva(ivaNew);
			}
			else {	
				double ivaNew = Double.parseDouble(iva);
				productToBeEdited.setIva(ivaNew);
			}

			System.out.println("diga qual o valor do pvp");
			String pvp = sc.nextLine();

			if(pvp.length()==0) {
				double pvpNew = productRepository1.consultById(id).getPvp();
				productToBeEdited.setPvp(pvpNew);
			}
			else {	
				double pvpNew = Double.parseDouble(pvp);
				productToBeEdited.setPvp(pvpNew);

			}
		
			System.out.println("novo producto: "+ productToBeEdited.toString());

		}
		else {
			System.out.println("Esse produto nao existe" + id);

		}
		
		menus();
	}




//menu de consultar produto

	private void consultProduct () {
		Scanner sc = new Scanner(System.in);
		System.out.println("Colocar o id do produto:");

		long id = sc.nextLong();
		sc.nextLine();
		
		if(productRepository1.consultById(id)!=null) {
			Product productToBeConsult = productRepository1.consultById((long)id);

			System.out.println("Produto: "+ productToBeConsult.toString());
		}
		else {
			System.out.println("Esse id de produto nao existe");
			System.out.println("continuar a consulta(1) ou ir para menu(2)?");
			char opcao = sc.nextLine().charAt(0);
			switch (opcao) {
			case '1':
				consultProduct();
				break;
			case '2':
				menus();
				break;

			default:consultProduct();
				break;
			}
			
		}
		
	
		menus();

	}
//menu remover produto
	
	private void removeProduct() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Colocar o id do produto a remover:");
		long id= sc.nextLong();
		sc.nextLine();
		if(productRepository1.consultById(id)!=null) {

			Product consultProduct = productRepository1.consultById(id);
			
			System.out.println("prateleiras existente no produto"+consultProduct.getListShelfIn());
			Iterator<Shelf> shelfList = consultProduct.getListShelfIn().iterator();
			
			
			
			System.out.println("o produto a remover e este: " + consultProduct.toString());
			System.out.println("Quer remover? y ou n");
			char remove = Character.toLowerCase(sc.nextLine().charAt(0));

			switch (remove) {
			case 'y':
				while (shelfList.hasNext()){

					shelfList.next().setProdutoAlberga(null);
				}
				productRepository1.removeById(id);
				
				System.out.println("foi removido o produto.");
				menus();
				break;

			case 'n':
				menus();
				break;
			default:menus();

			break;

			}

		}else {
			System.out.println("Esse id nao existe!!!");
			menus();

		}
		sc.close();
		
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
			System.out.println("1) Criar nova prateleira");
			newShelf();
			break;
		case '2':
			System.out.println("2) Editar prateleira existente");
			editShelf();
			break;
		case '3':
			System.out.println("3) Consultar o detalhe da prateleira");
			consultShelf();
			break;
		case '4':
			System.out.println("4) Remover prateleira");
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
		
		int caps =0;
		Product idProduct=null;
		double precoAluguer=0;
		Scanner sc = new Scanner(System.in);

		boolean continueInput = true;
		do {
		
		try {
			System.out.println("Coloque o valor de capacidade");
			caps= sc.nextInt();
			sc.nextLine();
			continueInput = false;

		}catch (InputMismatchException ex) {
			System.out.println("Erro: coloque o valor correcto.");
			sc.nextLine();
		}
		} while (continueInput);
			
		
		
		
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

		boolean continueInput2 = true;

		do {
		try {
			System.out.println("colocar o preco do Aluger");
			precoAluguer =sc.nextDouble(); 
			sc.nextLine();
			continueInput2=false;


		}catch (InputMismatchException ex) {
			System.out.println("Erro: coloque o valor correcto.");
			sc.nextLine();
		}
		} while (continueInput2);



		Shelf shelf1= new Shelf(caps, idProduct, precoAluguer);
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
			
			System.out.println("novo valor de capacidade");
			String capacidade = sc.nextLine();
			
			if(capacidade.length()==0) {
				int capacidadeNew= shelfRepository1.consultById(id).getCapacidade();
				shelfToEdited.setCapacidade(capacidadeNew);
			}


			else{
				boolean continueInput = true;
				do {
					try {
						int capacidadeNew= Integer.parseInt(capacidade);
						shelfToEdited.setCapacidade(capacidadeNew);	
						continueInput = false;
					}catch (InputMismatchException ex){
						System.out.println("Erro: coloque o valor correcto.");
						sc.nextLine();


					}
				}while (continueInput);
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

			System.out.println("novo valor de preco do Aluguer");
			String precoAluguer = sc.nextLine();

			if(precoAluguer.length()==0) {
				double precoAluguerNew= shelfRepository1.consultById(id).getPrecoAluguer();
				shelfToEdited.setPrecoAluguer(precoAluguerNew);
			}


			else{
				boolean continueInput1 = true;
				do {
					try {
						double precoAluguerNew= Double.parseDouble(precoAluguer);
						shelfToEdited.setPrecoAluguer(precoAluguerNew);	
						continueInput1 = false;
					}
					catch (InputMismatchException ex){
						System.out.println("Erro: coloque o valor correcto.");
						sc.nextLine();
					}
				}while(continueInput1);
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

