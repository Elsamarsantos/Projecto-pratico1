package io.altar.stateMachine.statees;

public class MenuListarShelves implements State {

	@Override
	public int execute() {
		System.out.println("Lista de Shelfs:");

		System.out.println("1) Criar nova prateleira");
		System.out.println("2) Editar prateleira existente");
		System.out.println("3) Consultar o detalhe da prateleria");
		System.out.println("4) Remover prateleira");
		System.out.println("5) Voltar ao ecra anterior");
	
		int [] valoresValidos = {1,2,3,4,5};
		
		return scannerUtils.getValidIntFromScanner("Escolha a opcao:",valoresValidos);
	}

}
