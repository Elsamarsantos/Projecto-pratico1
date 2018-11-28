package io.altar.stateMachine.jseproject.textInterface.states;

import io.altar.stateMachine.jseproject.utils.ScannerUtilsState;

public interface States {
	public static final ScannerUtilsState scannerUtils = new ScannerUtilsState();
	
	public int execute();
}
