package io.altar.stateMachine.jseproject.textInterface.utils;

import java.util.Scanner;

import io.altar.stateMachine.jseproject.model.Product;
import io.altar.stateMachine.jseproject.model.Shelf;
import io.altar.stateMachine.jseproject.repositories.ProductRepository;
import io.altar.stateMachine.jseproject.repositories.ShelfRepository;



public class ScannerUtilsState {

	private  Scanner sc =new Scanner(System.in);
	ProductRepository productRepository1 = ProductRepository.getInstance();
	ShelfRepository shelfRepository1= ShelfRepository.getInstance();
	
// definir qual o tipo de input	
	private  boolean isType(String input, String type) {
		Scanner lineSc = new Scanner(input);
		boolean result = false;
		
		switch (type) {
		case "Integer":
			if (lineSc.hasNextInt()) {
				result = true;
			} else {
				System.out.println("Valor errado: tem de ser um int");
			}
			break;
			
			
		case "Double":
			if (lineSc.hasNextDouble()) {
				result = true;
			} else {
				System.out.println("Valor errado: tem de ser um double");
				
			}
			break;
		case "Long":
			if (lineSc.hasNextLong()) {
				result = true;
			} else {
				System.out.println("Valor errado: tem de ser um long");
				
			}
			break;
	

		}
		lineSc.close();
		return result;
		
	}
	
	
	
	
	//metodo para retornar um double
	public double  getDoubleScanner(String mensage) {
		return getDoubleScanner(mensage,false);
	}

	public double getDoubleScanner(String mensage, boolean canBeNull) {
		String input;
		do {
			System.out.println(mensage);
			input=sc.nextLine();
			if(canBeNull && input.equals("")) { //excecao quando o input � um enter
				return -1;
			}

		} while (!isType(input,"Double"));

		return Double.parseDouble(input);

	}
	
//metodo para retornar um double o valor maximo max
	public double getValidDoubleScanner(String mensage,double max) {
		return getValidDoubleScanner(mensage,max,false);
	}

	public double getValidDoubleScanner(String mensage,double max, boolean canBeNull) {
		double result;
		do {
			result = getDoubleScanner(mensage,canBeNull);
			if(result>max) {
				System.out.println("o numero tem que ser menor que " + max);
			}
		} while (result>max);


		return result;

	}	
	
		
//metodo para retornar um long
	public long  getLongScanner(String mensage) {
		return getLongScanner(mensage,false);
	}
	
	public long getLongScanner(String mensage, boolean canBeNull) {
		String input;
		do {
			System.out.println(mensage);
			input=sc.nextLine();
			if(canBeNull && input.equals("")) { //excecao quando o input � um enter
				return -1;
			}
			
		} while (!isType(input,"Long"));
		
		return Long.parseLong(input);
		
	}
//metodo para retornar um integer
		public int  getIntScanner(String mensage) {
			return getIntScanner(mensage,false);
		}
		
		public int getIntScanner(String mensage, boolean canBeNull) {
			String input;
			do {
				System.out.println(mensage);
				input=sc.nextLine();
				if(canBeNull && input.equals("")) { //excecao quando o input � um enter
					return -1;
				}
				
			} while (!isType(input,"Integer"));
			
			return Integer.parseInt(input);
			
		}
		
		public int getValidIntFromScanner(String msg, int[] opcao) {
			return getValidIntFromScanner(msg, opcao, false);
		}
		
		public int getValidIntFromScanner(String msg, int[] ivas, boolean canBeNull) {
			int result;
			boolean validInt = false;
			do {
				result = getIntScanner(msg, canBeNull);
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
		
//metodo para procurar por id product
		public Product getProductById(String mensage,boolean canBeNull) {
			Long id;
			Product productById;
			do {
				
				id = getLongScanner(mensage,canBeNull);
				if(id==-1)
					return null;
				productById=productRepository1.consultById(id);
			

			} while (productById==null);

			return productById;
		}
		
		
		
//metodo para procurar por id shelf
		public Shelf getShelfById(String message,boolean canBeNull) {
			Long id;
			Shelf shelfById;
			do {
				id = getLongScanner(message,canBeNull);
				shelfById=shelfRepository1.consultById(id);


			} while (shelfById==null);

			return shelfById;
		}
		
		

}
