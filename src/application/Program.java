package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.ImportedProduct;
import model.entities.Product;
import model.entities.UsedProduct;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> lista = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.println("Quantos produtos deseja declarar:");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			System.out.println("O produto é Comum, Importado ou Usado? C/I/U ");
			char c = sc.next().charAt(0);
			System.out.println("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.println("Preço: ");
			Double preco = sc.nextDouble();
			
			if(c == 'U' || c == 'u') {
				System.out.println("Data de Fabricação: DD/MM/YYYY");
				Date fabricacao = sdf.parse(sc.next());
				lista.add(new UsedProduct(nome, preco, fabricacao));
			}else if(c == 'I' || c == 'i') {
				System.out.println("Taxa de importação: ");
				Double taxa = sc.nextDouble();
				lista.add(new ImportedProduct(nome, preco, taxa));
			}else {
				lista.add(new Product(nome, preco));
			}
		}
		
		for(Product p: lista) {
			System.out.println(p.priceTag());
		}
		
		sc.close();
	}

}
