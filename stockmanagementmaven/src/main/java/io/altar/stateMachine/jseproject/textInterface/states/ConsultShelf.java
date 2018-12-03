package io.altar.stateMachine.jseproject.textInterface.states;

import io.altar.stateMachine.jseproject.model.Shelf;

public class ConsultShelf implements States {

	@Override
	public int execute() {

		Shelf shelfconsult= scannerUtils.getShelfById("Coloque o id da Shelf", true);

		if(shelfconsult!=null) {

			System.out.println("Shelf: " + shelfconsult.toString());
		}
		else {
			System.out.println("Essa prateleira nao existe");
		}
		return 1;
	}

}
