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
        
    	// Constructor method of the Sales class.
        public Sales(Seller seller, Product product, int amount) {
            this.seller  = seller;
            this.product = product;
            this.amount  = amount;
        }

        // Method of obtaining total sales
        double getTotalsSales() {
            return product.priceByUnit * amount;
        }
    }
    
        // Creation of the main method   
        public static void main(String[] args) {
    	
    	// Generating a seller list array
         List<Seller> seller = new ArrayList<>(Arrays.asList(
         new Seller("CC", "1001", "Juan", "Perez"),
         new Seller("CC", "1002", "Ana", "Gomez"),
         new Seller("CC", "1003", "Carlos", "Martinez"),
         new Seller("CC", "1004", "Luisa", "Rodriguez"),
         new Seller("CC", "1005", "Pedro", "Lopez")));
         
         // Generating a product list array
        List<Product> product = new ArrayList<>(Arrays.asList(
        new Product("P001", "Refrigerador",    1800000),
        new Product("P002", "Lavadora",        650000),
        new Product("P003", "Microondas",      350000),
        new Product("P004", "Licuadora",       200000),
        new Product("P005", "Horno eléctrico", 250000),
        new Product("P006", "Tostadora",       80000),
        new Product("P007", "Cafetera",        60000),
        new Product("P008", "Aspiradora",      120000),
        new Product("P009", "Plancha",         70000),
        new Product("P010", "Ventilador",      65000)));

     // Called the method that generates the product file
        generateProductFile(product);

     // Called the method that generates the sellers file
        generateSellerFile(seller);
    }

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
            writer.write(sellers.documentType + "," + sellers.documentNumber + "," + sellers.namesSeller + "," + sellers.surnamesSeller + "\n");
            }
            
         // Completion message with the successful procedure
            System.out.println("Sellers file generated successfully.");
            
         } 
        // Completion message with the procedure with error
        catch (IOException e) {
            System.err.println("Error writing to Sellers file: " + e.getMessage());
        }
    }
}