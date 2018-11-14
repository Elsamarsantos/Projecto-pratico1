package io.altar.jseproject.textinterface;

import java.util.Scanner;

import io.altar.jseproject.model.Shelf;

public class TextInterface {
	
	;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println("A escolha foi " + janela1(opcao));
		menuInicial();
	}

	private static void menuInicial() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1) Listar produtos");
		System.out.println("2) Listar prateleiras");
		System.out.println("3) Sair");
		System.out.println("Escolha a opcao:");
		char opcao = sc.nextLine().charAt(0);
	
		if (opcao == 1) {
			menuListarProdutos();

		} else if (opcao == 2) {

			System.out.println("2) Listar prateleiras");
		}

		else if (opcao == 3) {
			System.out.println("Sair");

		} else {
			System.out.println("erro:escolha so opcao 1, 2 ou 3");
			menuInicial();
		}
		sc.close();
		

	}

	private static void menuListarProdutos() {
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
			System.out.println("erro:escolha so opcao 1, 2 ou 3");
			menuListarProdutos();
			break;
		
		
		}
		sc.close();

	}
	private static void criarNovoProduto() {
		
/**		o id e gerado posteriormente, isto e para apagar**/
		
		System.out.print("colocar o id:");
		Scanner sc = new Scanner(System.in);
		char id = sc.nextLine().charAt(0);

/**		o id e gerado posteriormente, isto e para apagar**/		
		System.out.print("lista onde o produto esta:");
		Scanner sc = new Scanner(System.in);
		String list = sc.nextLine();
		
		
		System.out.print("colocar o valor de desconto:");
		Scanner sc = new Scanner(System.in);
		int valorDesconto= sc.nextInt();
		
		System.out.print("colocar o valor do iva:");
		Scanner sc = new Scanner(System.in);
		int iva= sc.nextInt();
		
		System.out.print("colocar o valor do pvp:");
		Scanner sc = new Scanner(System.in);
		char pvp= sc.nextLine().;
		
		
		char opcao = sc.nextLine().charAt(0);
	
	
	
	

}
