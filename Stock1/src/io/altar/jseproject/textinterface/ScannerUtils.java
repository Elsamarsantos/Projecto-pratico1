package io.altar.jseproject.textinterface;

import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;

public class ScannerUtils {
	private  Scanner sc =new Scanner(System.in);
	ProductRepository productRepository1 = ProductRepository.getInstance();
	
// definir qual o tipo de input	
	private  boolean isType(String input, String type) {
		switch (type) {
		case "Integer":
			try {
				Integer.parseInt(input);
				return true;
			}catch (NumberFormatException e) {
				System.out.println("Valor errado: tem de ser um int");
				return false;
			}
		case "Double":
			try {
				Double.parseDouble(input);
				return true;
			}catch (NumberFormatException e) {
				System.out.println("Valor errado: tem de ser um double");
				return false;
			}
		case "Long":
			try {
				Long.parseLong(input);
				return true;
			}catch (NumberFormatException e) {
				System.out.println("Valor errado: tem de ser um long");
				return false;
			}

		default:
			return false;


		}
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
			if(canBeNull && input.equals("")) { //excecao quando o input é um enter
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
			if(canBeNull && input.equals("")) { //excecao quando o input é um enter
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
				if(canBeNull && input.equals("")) { //excecao quando o input é um enter
					return -1;
				}
				
			} while (!isType(input,"Integer"));
			
			return Integer.parseInt(input);
			
		}
		
//metodo para procurar por id product
		public Product getProductById(String message,boolean canBeNull) {
			Long id;
			Product productById;
			do {
				id = getLongScanner(message,canBeNull);
				productById=productRepository1.consultById(id);
				
				
			} while (productById==null);
				
			return productById;
		}
		
		
		
}
