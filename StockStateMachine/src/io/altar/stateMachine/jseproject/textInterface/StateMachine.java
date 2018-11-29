package io.altar.stateMachine.jseproject.textInterface;

import io.altar.stateMachine.jseproject.textInterface.states.*;

public class StateMachine {
	
private States[] states = {new MenuInicial(),  		// 0
							new MenuProduct(), 		// 1
							new MenuShelves(), 		// 2
							new NewProduct(), 		// 3
							new EditProduct(), 		// 4 
							new ConsultProduct(), 	// 5
							new RemoveProduct(), 	// 6
							new NewShelf(), 		// 7
							new EditShelf(), 		// 8
							new ConsultShelf(), 	// 9
							new RemoveShelf() 		// 10
							};
	
	private int transitionsMatrix [][]= {
			{1,2},									//state 0
			{3,4,5,6,0},							//state 1
			{7,8,9,10,0}, 							//state 2
			{1},									//state 3
			{1},									//state 4
			{1},									//state 5
			{1},									//state 6
			{2},									//state 7
			{2},									//state 8
			{2},									//state 9
			{2}										//state 10
	
	};
	private int currentState=0;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StateMachine runMachine = new StateMachine();
		int opcao;
		while(true) {
		opcao= runMachine.states[runMachine.currentState].execute();
		runMachine.currentState= runMachine.transitionsMatrix[runMachine.currentState][opcao-1]; //(-1 tem a ver com o array comecar no zero e a lista comeca no 1)
		}
		
		
	}

}
