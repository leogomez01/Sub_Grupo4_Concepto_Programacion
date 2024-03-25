//Import of all classes and utilities from the java. package

package productoVentas;

import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("unused")

public class GenerateInfoFiles { // Class that generates the information of the requested files

	// Creation of the Product Class, whic its attributes.
	static class Product {
		String idProduct;
		String nameProduct;
		double priceByUnit;

		// Constructor method of the product class.
		public Product(String idProduct, String nameProduct, double priceByUnit) {
			this.idProduct = idProduct;
			this.nameProduct = nameProduct;
			this.priceByUnit = priceByUnit;
		}
	}

	// Creation of the Seller class, whic its attributes.
	static class Seller {
		String documentType;
		String documentNumber;
		String namesSeller;
		String surnamesSeller;

		// Constructor method of the Seller class.
		public Seller(String documentType, String documentNumber, String namesSeller, String surnamesSeller) {
			this.documentType = documentType;
			this.documentNumber = documentNumber;
			this.namesSeller = namesSeller;
			this.surnamesSeller = surnamesSeller;
		}

	}

	// Creation of the Product Sales, whic its attributes.
	static class Sales {
		Seller seller;
		Product product;
		int amount;
		double totalSalesProduct;

		// Constructor method of the Sales class.
		public Sales(Seller seller, Product product, int amount, double totalSalesProduct) {
			this.seller = seller;
			this.product = product;
			this.amount = amount;
			this.totalSalesProduct = totalSalesProduct;
		}

		// Method of obtaining total sales
		double getTotalsSales() {
			return product.priceByUnit * amount;
		}
	}

	// Creation of the main method
	public static void main(String[] args) {

		// Generating a seller list array
		List<Seller> seller = new ArrayList<>(Arrays.asList(new Seller("CC", "1001", "Juan", "Perez"),
				new Seller("CC", "1002", "Ana", "Gomez"), new Seller("CC", "1003", "Carlos", "Martinez"),
				new Seller("CC", "1004", "Luisa", "Rodriguez"), new Seller("CC", "1005", "Pedro", "Lopez")));

		// Generating a product list array
		List<Product> product = new ArrayList<>(
				Arrays.asList(new Product("P001", "Refrigerador", 1800000), new Product("P002", "Lavadora", 650000),
						new Product("P003", "Microondas", 350000), new Product("P004", "Licuadora", 200000),
						new Product("P005", "Horno eléctrico", 250000), new Product("P006", "Tostadora", 80000),
						new Product("P007", "Cafetera", 60000), new Product("P008", "Aspiradora", 120000),
						new Product("P009", "Plancha", 70000), new Product("P010", "Ventilador", 65000)));

		// Generating a Sales list array
		List<Sales> sales = new ArrayList<>();
		Random random = new Random();
		for (Product product2 : product) {
			Seller seller2 = seller.get(random.nextInt(seller.size()));
			int amount = 1 + random.nextInt(10);
			double totalSalesProduct = product2.priceByUnit * amount;
			sales.add(new Sales(seller2, product2, amount, totalSalesProduct));
		}

		// Called the method that generates the product file
		generateProductFile(product);

		// Called the method that generates the sellers file
		generateSellerFile(seller);

		// Called the method that generates the sellers file
		generateSalesFile(sales);

	}

	// Method that generates the product flat file
	private static void generateProductFile(List<Product> product) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("products.txt"))) {
			for (Product products : product) {
				writer.write(products.idProduct + "," + products.nameProduct + "," + products.priceByUnit + "\n");
			}
			// Completion message with the successful procedure
			System.out.println("Products file generated successfully.");

			// Completion message with the procedure with error
		} catch (IOException e) {
			System.err.println("Error writing to products file: " + e.getMessage());
		}
	}

	// Method that generates the seller flat file
	private static void generateSellerFile(List<Seller> seller) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Sellers.txt"))) {
			for (Seller sellers : seller) {
				writer.write(sellers.documentType + "," + sellers.documentNumber + "," + sellers.namesSeller + ","
						+ sellers.surnamesSeller + "\n");
			}

			// Completion message with the successful procedure
			System.out.println("Sellers file generated successfully.");

		}
		// Completion message with the procedure with error
		catch (IOException e) {
			System.err.println("Error writing to Sellers file: " + e.getMessage());
		}
	}

	// Method that generates the sales flat file
	public static void generateSalesFile(List<Sales> sales) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Sales.txt"))) {
			for (Sales sales2 : sales) {

				writer.write(sales2.product.idProduct + "," + sales2.product.nameProduct + ","
						+ sales2.product.priceByUnit + "," + sales2.amount + "," + "," + sales2.seller.documentType
						+ ";" + sales2.seller.namesSeller + ";" + sales2.seller.surnamesSeller + ","
						+ sales2.seller.documentNumber + "," + sales2.totalSalesProduct + "\n");
			}
			// Completion message with the successful procedure
			System.out.println("Sales file generated successfully.");

			// Completion message with the procedure with error
		} catch (IOException e) {
			System.err.println("Error writing to Sales file: " + e.getMessage());

		}

	}
}
