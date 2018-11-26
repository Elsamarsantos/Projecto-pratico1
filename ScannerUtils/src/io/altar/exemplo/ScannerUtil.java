package io.altar.exemplo;

import java.util.Scanner;

public class ScannerUtil {
	private  Scanner sc =new Scanner(System.in);
	
	
	public int  getIntFromScanner(String msg, boolean canBeNull) {
		String input;
		do {
			System.out.println(msg);
			input = sc.nextLine();
			if(canBeNull && input.equals("")) {
				return -1;
			}
		} while (!isType(input, "Integer"));
		
		return Integer.parseInt(input);
	}
	
	public int  getIntFromScanner(String msg) {
		
		return getIntFromScanner(msg,false);
	}
	
	

	public int getValidIntFromScanner(String msg, int max) {
		int result;
		do {
			result =getIntFromScanner(msg);
			if(result>max) {
				System.out.println("o numero tem que ser menor que " + max);
			}
		} while (result>max);
		
		
		
		
		return result;
	}
	
	public int getValidIntFromScanner(String msg, int[] ints) {
		return getValidIntFromScanner(msg,ints,false);
	}
	
	public int getValidIntFromScanner(String msg, int[] ints, boolean canBeNull) {
		int result;
		boolean validInt = false;
		do {
			result = getIntFromScanner(msg,canBeNull);
			for (int i:ints) {
				if(i == result) {
					validInt = true;

				}
			}
			if (!validInt) {
				String validString="";
				for (int i:ints) {
					validString += " " + i;
				}
				System.out.println("Numero errado" + validString);
			}

		} while (!validInt);

		return result;


		
		
	}
	public float getfloatFromScanner(String msg) {
		String input;
		do {
			System.out.println(msg);
			input = sc.nextLine();
		} while (!isType(input, "Float"));
		
		return Float.parseFloat(input);
	}
	
	private  boolean isType(String input, String type) {
		switch (type) {
		case "Integer":
		try {
			Integer.parseInt(input);
			return true;
		}catch (NumberFormatException e) {
			System.out.println("Valor errado");
			return false;
		}
		case "Float":
			try {
				Float.parseFloat(input);
				return true;
			}catch (NumberFormatException e) {
				System.out.println("Valor errado");
				return false;
			}
			
			default:
				return false;
			
			
		}
	}

}