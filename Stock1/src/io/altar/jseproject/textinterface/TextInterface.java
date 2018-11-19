package io.altar.jseproject.textinterface;

import java.util.ArrayList;
import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class TextInterface {
	
	;

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		menuInicial();
	}
// menu inicial 
	private static void menuInicial() {
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
	private static void menuListarProdutos() {
		
		//String [] listaProdutos={} ;
//		Product produto1= new Product (1,[1],3,23,2.00);
//					
//		
//			
//				
//		ArrayList<String> listaProdutos= new ArrayList<String>();
//		listaProdutos.add(Product.getId());
//				
//		System.out.println(listaProdutos);
		
		
		
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
			System.out.println("boa");
			break;
		case '3':
			System.out.println("muito bem");
			break;
		case '4':
			System.out.println("maios ou menos");
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
	private static void menuListarPrateleiras() {
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
	
	private static void criarNovoProduto() {
		Scanner sc = new Scanner(System.in);
		
		

		System.out.println("lista onde o produto esta:");
		try {
			String listS = sc.nextLine();
			int list = Integer.parseInt(listS);
		}catch (Exception e) {
			System.out.println("Erro: "+ e);
			sc.nextLine();
			criarNovoProduto();

		}




		System.out.println("colocar o valor de desconto:");
		try {

			String valorDescontoS= sc.nextLine();
			int valorDesconto = Integer.parseInt(valorDescontoS);
		}catch (Exception e) {
			System.out.println("Erro: "+ e);
			sc.nextLine();
			criarNovoProduto();

		}




		System.out.println("colocar o valor do iva:");
		try {
			
			String ivaS= sc.nextLine();
			double iva = Double.parseDouble(ivaS);

		}catch (Exception e) {
			System.out.println("Erro: "+ e);
			sc.nextLine();
			criarNovoProduto();
		}


		System.out.println("colocar o valor do pvp:");
		try {

			String pvpS= sc.nextLine();
			double pvp = Double.parseDouble(pvpS);
			
		}catch (Exception e) {
			System.out.println("Erro: "+ e);
			sc.nextLine();
			criarNovoProduto();

		}
		
	}

}
