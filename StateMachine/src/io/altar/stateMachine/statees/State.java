package io.altar.stateMachine.statees;

import io.altar.stateMachine.utils.ScannerUtils;

public interface State {
	public static final ScannerUtils scannerUtils = new ScannerUtils();
	
	public int execute();

}
