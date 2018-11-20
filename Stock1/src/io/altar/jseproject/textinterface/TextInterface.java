package io.altar.jseproject.textinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

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

			System.out.println("2) Listar prateleiras");
		}

		else if (opcao == '3') {
			System.out.println("Sair");

		} else {
			System.out.println("erro:escolha so opcao 1, 2 ou 3");
			menuInicial();
		}
		sc.close();
		

	}
//menu de produtos
	private void menuListarProdutos() {
		

//			
//				
//		ArrayList<String> listaProdutos= new ArrayList<String>();
//		listaProdutos.add(Product.getId());
//				
//		System.out.println(listaProdutos);
		
	//	Iterator it <Product> = new Iterator;
		
		
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
			criarNovoProduto();
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
//menu de prateleiras
	private  void menuListarPrateleiras() {
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
			criarNovoProduto();
			break;
		case '2':
			System.out.println("2) Editar prateleira existente");
			break;
		case '3':
			System.out.println("3) Consultar o detalhe da prateleria");
			break;
		case '4':
			System.out.println("4) Remover prateleira");
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
	
	private void criarNovoProduto() {
		
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
			criarNovoProduto();

		}

		System.out.println("colocar o valor do iva:");
		try {
			
			String ivaS= sc.nextLine();
			iva = Double.parseDouble(ivaS);

		}catch (Exception e) {
			System.out.println("Erro: "+ e);
			sc.nextLine();
			criarNovoProduto();
		}


		System.out.println("colocar o valor do pvp:");
		try {

			String pvpS= sc.nextLine();
			pvp = Double.parseDouble(pvpS);
			
		}catch (Exception e) {
			System.out.println("Erro: "+ e);
			sc.nextLine();
			criarNovoProduto();

		}
		
		Product product1= new Product(null, valorDesconto, iva, pvp);
		
		productRepository1.saveId(product1);
	
		System.out.println("novo producto: "+ product1.toString());
		
		System.out.println("quer voltar ao menu Produtos? y ou n");
		char opcao= sc.nextLine().charAt(0);

		switch (opcao) {
		case 'y':
			menuListarProdutos();
			break;
		case 'n':
			menuInicial();

		default:menuInicial();
		break;
		}
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
			

			productRepository1.editById(productToBeEdited);
			System.out.println("novo producto: "+ productToBeEdited.toString());
		
		
		
		}else {
			System.out.println("Esse produto nao existe" + id);
			sc.nextLine();
			editProduct();

		}
		System.out.println("quer voltar ao menu Produtos? y ou n");
		char opcao= sc.nextLine().charAt(0);

		switch (opcao) {
		case 'y':
			menuListarProdutos();
			break;
		case 'n':
			menuInicial();

		default:menuInicial();
		break;
		}
		sc.close();

	}




	

	private void consultProduct () {
		Scanner sc = new Scanner(System.in);
		System.out.println("Colocar o id do produto:");
		
		long id = sc.nextLong();
		sc.nextLine();
		Product productToBeConsult = productRepository1.consultById((long)id);
		
		System.out.println("produto: "+ productToBeConsult.toString());
		
		
		System.out.println("quer voltar ao menu Produtos? y ou n");
		char opcao= sc.nextLine().charAt(0);

		switch (opcao) {
		case 'y':
			menuListarProdutos();
			break;
		case 'n':
			menuInicial();

		default:menuInicial();
		break;
		}
		sc.close();
		
		
	}
}
