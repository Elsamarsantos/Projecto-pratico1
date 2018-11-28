package io.altar.stateMachine.jseproject.textInterface.states;

import io.altar.stateMachine.jseproject.model.Shelf;

public class ConsultShelf implements States {

	@Override
	public int execute() {

		Shelf shelfconsult= scannerUtils.getShelfById("Coloque o id da Shelf", true);

		System.out.println("Shelf: " + shelfconsult.toString());

		return 2;
	}

}
