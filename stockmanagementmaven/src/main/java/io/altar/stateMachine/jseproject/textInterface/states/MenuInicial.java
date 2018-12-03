package io.altar.stateMachine.jseproject.textInterface.states;

public class MenuInicial implements States {
	
	@Override
	public int execute() {
		System.out.println("1) Listar produtos");
		System.out.println("2) Listar prateleiras");
		System.out.println("3) Sair");
		
		
		int [] opcao= {1,2,3};
		
		return scannerUtils.getValidIntFromScanner("Escolha a opcao:",opcao);
	}
}
