package io.altar.jseproject.textinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
	public  void menuInicial() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1) Listar produtos");
		System.out.println("2) Listar prateleiras");
		System.out.println("3) Sair");
		System.out.println("Escolha a opcao:");
		char opcao = sc.nextLine().charAt(0);
		
		if (opcao == '1') {
			menuListarProdutos();

		} else if (opcao == '2') {
			menuListarPrateleiras();
		}

		else if (opcao == '3') {
			System.out.println("Sair");

		} else {
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
		

		
		char opcao = sc.nextLine().charAt(0);
		
		switch(opcao) {
		case '1':
			System.out.println("1) Criar novo produtos");
			newProdut();
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
			menuInicial();break;
		default: 	
			System.out.println("erro:escolha so opcao 1, 2, 3, 4 ou 5");
			menuListarProdutos();
			break;
		
		
		}
		sc.close();

	}


// comeca o criar produto	
	
	private void newProdut() {
		
		double valorDesconto=0;
		double iva=0;
		double pvp=0;
		Scanner sc = new Scanner(System.in);

		System.out.println("colocar o valor de desconto:");
		try {

			String valorDescontoS= sc.nextLine();
			valorDesconto = Integer.parseInt(valorDescontoS);
		}catch (Exception e) {
			System.out.println("Erro: "+ e);
			sc.nextLine();
			newProdut();

		}

		System.out.println("colocar o valor do iva:");
		try {
			
			String ivaS= sc.nextLine();
			iva = Double.parseDouble(ivaS);

		}catch (Exception e) {
			System.out.println("Erro: "+ e);
			sc.nextLine();
			newProdut();
		}


		System.out.println("colocar o valor do pvp:");
		try {

			String pvpS= sc.nextLine();
			pvp = Double.parseDouble(pvpS);
			
		}catch (Exception e) {
			System.out.println("Erro: "+ e);
			sc.nextLine();
			newProdut();

		}
		
	
			
		Product product1= new Product(valorDesconto, iva, pvp);
		
		productRepository1.saveId(product1);
	
		System.out.println("novo producto: "+ product1.toString());
		
		menus();
		

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



		}else {
			System.out.println("Esse produto nao existe" + id);

			editProduct();
			sc.nextLine();
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

			Product consultById = productRepository1.consultById(id);

			System.out.println("o produto a remover e esta: " + consultById.toString());
			System.out.println("Quer remover? y ou n");
			char remove = Character.toLowerCase(sc.nextLine().charAt(0));

			switch (remove) {
			case 'y':
				productRepository1.removeById(id);
				productRepository1.;
				System.out.println("foi removida o produto.");
				menus();
				break;

			case 'n':
				menus();
				break;
			default:removeProduct();
			break;

			}

		}else {
			System.out.println("Esse id nao existe!!!");
			removeProduct();
		}
		sc.close();
		//menus();
	}

/*menu de prateleiras */
	
	//lista das prateleiras
	private  void menuListarPrateleiras() {
		System.out.println("Lista de Shelfs:");
		Iterator <Shelf> ShelfList = shelfRepository1.consultAll().iterator();
		while(ShelfList.hasNext()) {
		System.out.println(ShelfList.next());
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
			System.out.println("3) Consultar o detalhe da prateleria");
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
		Scanner sc = new Scanner(System.in);
		
		System.out.println("colocar a capacidade");
		String capacidade = sc.nextLine();
		int caps= Integer.parseInt(capacidade);
		
		System.out.println("colocar o produto que alberga");
		long id= sc.nextLong();
		sc.nextLine();
		Product idProduct = productRepository1.consultById(id);
		
		System.out.println("colocar o preco do Aluger");
		String precoAluguer = sc.nextLine();
		double precoAluguerS = Double.parseDouble(precoAluguer);
		
		Shelf shelf1= new Shelf(caps, idProduct, precoAluguerS);
		shelfRepository1.saveId(shelf1);
		idProduct.addToListShelves(shelf1);
		System.out.println(shelf1.toString());
		
		menus();
	}
//editar prateleira
	
	private void editShelf() {
				
		Scanner sc= new Scanner (System.in);
		System.out.println("Qual o Id do produto a alterar");
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
				int capacidadeNew= Integer.parseInt(capacidade);
				shelfToEdited.setCapacidade(capacidadeNew);	
			}
			
			System.out.println("novo valor de preco do Aluguer");
			String precoAluguer = sc.nextLine();
			
			if(precoAluguer.length()==0) {
				double precoAluguerNew= shelfRepository1.consultById(id).getPrecoAluguer();
				shelfToEdited.setPrecoAluguer(precoAluguerNew);
			}

			else{
				double precoAluguerNew= Double.parseDouble(precoAluguer);
				shelfToEdited.setPrecoAluguer(precoAluguerNew);	
			}
		
			
		}else {
			System.out.println("Esse Id de Shelf nao existe!!!");
			editShelf();
			
		}sc.close();
		
	
		menus();
	}
//consulta prateleiras
	private void consultShelf() {
						
		Scanner sc= new Scanner(System.in);
		System.out.println("Coloque o id do produto a pesquisar ");
		long id= sc.nextLong();;
		sc.nextLine();
		
		if(shelfRepository1.consultById(id)!=null) {
			Shelf shelfconsult = shelfRepository1.consultById(id);
			
			System.out.println("Shelf: " + shelfconsult.toString());
			
		}else {
			System.out.println("Essa shelf nao existe");
			consultShelf();
		}sc.close();
		
		menus();
	}

//remover prateleiras
	private void removeShelf() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Coloque o id do produto a remover ");
		long id = sc.nextLong();
		sc.nextLine();
		if(shelfRepository1.consultById(id)!=null) {	
			Shelf shelfconsult = shelfRepository1.consultById(id);
			System.out.println("A Shelf a remover e esta: " + shelfconsult.toString());
			System.out.println("Quer remover? y ou n");
			char remove = Character.toLowerCase(sc.nextLine().charAt(0));

			switch (remove) {
			case 'y':
				shelfRepository1.removeById(id);
				System.out.println("foi removida a shelf.");
				menus();
				break;

			case 'n':
				menus();
				break;

			default:removeShelf();
			break;
			}
			
		}else {
			System.out.println("Esse id nao existe!!!");
			removeProduct();
		}
		
		sc.close();
		menus();
	}


}

