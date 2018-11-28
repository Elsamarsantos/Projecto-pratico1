package io.altar.stateMachine.utils;

import java.util.Scanner;

public class ScannerUtils {
	private Scanner sc = new Scanner(System.in);

	public int getIntFromScanner(String msg, boolean canBeNull) {
		String input;
		
		do {
			System.out.println(msg);
			input = sc.nextLine();
			if (canBeNull && input.equals("")) {
				return -1;
			}
		} while (!isType(input, "Integer"));
		return Integer.parseInt(input);
	}

	public int getIntFromScanner(String msg) {
		return getIntFromScanner(msg, false);
	}

	public int getValidIntFromScanner(String msg, int max, boolean canBeNull) {
		int result;
		do {
			result = getIntFromScanner(msg, canBeNull);
			if (result > max)
				System.out.println("O Numero tem de ser menor que " + max);
		} while (result > max);
		return result;
	}

	public int getValidIntFromScanner(String msg, int max) {
		return getValidIntFromScanner(msg, max, false);
	}

	public int getValidIntFromScanner(String msg, int[] ivas, boolean canBeNull) {
		int result;
		boolean validInt = false;
		do {
			result = getIntFromScanner(msg, canBeNull);
			if (canBeNull && result == -1) {
				return -1;
			} else {
				for (int i : ivas) {
					if (result == i) {
						validInt = true;
					}
				}
				if (!validInt) {
					String validString = "";
					for (int i : ivas) {
						validString += " " + i;
					}
					System.out.println("Numero errado tem de ser" + validString);
				}
			}
		} while (!validInt);
		return result;
	}

	public int getValidIntFromScanner(String msg, int[] ivas) {
		return getValidIntFromScanner(msg, ivas, false);
	}

	public float getFloatFromScanner(String msg, boolean canBeNull) {
		String input;
		do {
			System.out.println(msg);
			input = sc.nextLine();
			if (canBeNull && input.equals("")) {
				return -1;
			}
		} while (!isType(input, "Float"));
		return Float.parseFloat(input);
	}

	public float getFloatFromScanner(String msg) {
		return getFloatFromScanner(msg, false);
	}

	public boolean isType(String input, String type) {
		Scanner lineSc = new Scanner(input);
		boolean result = false;
		switch (type) {
		case "Integer":
			if (lineSc.hasNextInt()) {
				result = true;
			} else {
				System.out.println("Numero invalido colocar um numero inteiro");
			}
			break;
		case "Float":
			if (lineSc.hasNextFloat()) {
				result = true;
			} else {
				System.out.println("Numero invalido colocar um numero flutuante");
			}
			break;
		default:
			result = true;
		}
		lineSc.close();
		return result;
	}
}


