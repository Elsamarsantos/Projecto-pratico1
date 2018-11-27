package io.altar.stateMachine.statees;

public class MenuListarProdut implements State {

	@Override
	public int execute() {
		System.out.println("Lista de Produtos:");
		
		
		System.out.println("1) Criar novo produtos");
		System.out.println("2) Editar um produto existente");
		System.out.println("3) Consultar o detalhe de um produto");
		System.out.println("4) Remover um produto");
		System.out.println("5) Voltar ao ecra anterior");
		
		int [] valoresValidos = {1,2,3,4,5};
		
		return scannerUtils.getValidIntFromScanner("Escolha a opcao:",valoresValidos);

		
	}

}
