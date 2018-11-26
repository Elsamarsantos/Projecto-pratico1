package io.altar.exemplo;

public class Testes {
	ScannerUtil scannerUtils= new ScannerUtil();

	public static void main(String[] args) {
		Testes testes= new Testes();
		testes.teste();

	}


	private void teste() {
		Product product = createProduct();
		System.out.println(product.toString());
		editProduct(product);
		System.out.println(product.toString());
	}

	private  Product createProduct() {
		System.out.println("Criar product");
		int[] ivas = new int[] {6,13,23};
		int iva = scannerUtils.getValidIntFromScanner("Mete o iva", ivas);	
		int pvp = scannerUtils.getIntFromScanner("Mete o pvp");
		int discount = scannerUtils.getValidIntFromScanner("Mete o discount",100);
		
		Product product = new Product (iva,pvp,discount);
		return product;
	}

	private void editProduct(Product product) {
		System.out.println("Editar Product");
		int[] ivas = new int[] {6,13,23};
		int iva = scannerUtils.getIntFromScanner("Iva antigo:"+product.getIva(), ivas, true);
		product.setIva(iva);	
		
		int pvp = scannerUtils.getIntFromScanner("Pvp antigo:"+ product.getPvp(),true);
		if(pvp !=-1) {
		product.setPvp(pvp);
		}
		
		int discount = scannerUtils.getValidIntFromScanner("discount antigo:" + product.getDiscount(),100),true;
		product.setDiscount(discount);
		

	}


}