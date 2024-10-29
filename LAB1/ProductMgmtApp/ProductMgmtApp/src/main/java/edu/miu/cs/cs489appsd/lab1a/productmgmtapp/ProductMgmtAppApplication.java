package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs489appsd.lab1a.productmgtapp.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

@SpringBootApplication
public class ProductMgmtAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMgmtAppApplication.class, args);

		Product[] products = {
				new Product(3128874119L, "Banana", "2023-01-24", 124, 0.55),
				new Product(2927458265L, "Apple", "2022-12-09", 18, 1.09),
				new Product(9189927460L, "Carrot", "2023-03-31", 89, 2.99)
		};
		printProducts(products);
	}

	private static void printProducts(Product[] products) {

		var sortedProducts= Arrays.stream(products).
				           sorted(Comparator.comparing(Product::getName))
				           .collect(Collectors.toList());

		// printing in json format
		System.out.println("Printed in JSON format");
		System.out.println("[");
		System.out.println(
				sortedProducts.stream()
						.map(p->String.format(" { \"productId\": %d, \"name\": \"%s\", \"dateSupplied\": \"%s\", \"quantityInStock\": %d, \"unitPrice\": %.2f }",
								p.getProductId(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice()))
						.collect(Collectors.joining(",\n"))
		);
		System.out.println("\n]");
		System.out.println("------------------------");

		System.out.println("Printed in XML format");
		System.out.println("<?xml version=\"1.0\"?>");
		System.out.println("<Products>");
		System.out.println(
				sortedProducts.stream()
						.map(p -> String.format("  <Product productId=\"%d\" name=\"%s\" dateSupplied=\"%s\" quantityInStock=\"%d\" unitPrice=\"%.2f\" />",
								p.getProductId(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice()))
						.collect(Collectors.joining("\n"))
		);
		System.out.println("</Products>");
		System.out.println("------------------------");

		System.out.println("Printed in Comma-Separated Value (CSV) format");
		System.out.println("ProductId,Name,DateSupplied,QuantityInStock,UnitPrice");
		System.out.println(
				sortedProducts.stream()
						.map(p -> String.format("%d,%s,%s,%d,%.2f",
								p.getProductId(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice()))
						.collect(Collectors.joining("\n"))
		);
	}

}
