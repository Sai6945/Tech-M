package Day5;

import java.util.*;

//Product class
class Product {
 int id;
 String name;
 double price;
 HashSet<String> categories;

 public Product(int id, String name, double price, HashSet<String> categories) {
     this.id = id;
     this.name = name;
     this.price = price;
     this.categories = categories;
 }

 @Override
 public String toString() {
     return id + " - " + name + " - $" + price + " - " + categories;
 }
}

//Comparator for sorting by price
class PriceComparatorAscending implements Comparator<Product> {
 @Override
 public int compare(Product p1, Product p2) {
     return Double.compare(p1.price, p2.price);
 }
}

class PriceComparatorDescending implements Comparator<Product> {
 @Override
 public int compare(Product p1, Product p2) {
     return Double.compare(p2.price, p1.price);
 }
}

public class ECommerceCatalog {
 private TreeMap<Integer, Product> productCatalog = new TreeMap<>();

 public void addProduct(int id, String name, double price, HashSet<String> categories) {
     productCatalog.put(id, new Product(id, name, price, categories));
 }

 public void listProductsSortedByPrice(boolean ascending) {
     List<Product> products = new ArrayList<>(productCatalog.values());
     products.sort(ascending ? new PriceComparatorAscending() : new PriceComparatorDescending());
     for (Product p : products) {
         System.out.println(p);
     }
 }

 public void searchProductsByPriceRange(double minPrice, double maxPrice) {
     for (Product p : productCatalog.values()) {
         if (p.price >= minPrice && p.price <= maxPrice) {
             System.out.println(p);
         }
     }
 }

 public static void main(String[] args) {
     ECommerceCatalog catalog = new ECommerceCatalog();
     catalog.addProduct(101, "Laptop", 1200.99, new HashSet<>(Arrays.asList("Electronics", "Computers")));
     catalog.addProduct(102, "Smartphone", 699.99, new HashSet<>(Arrays.asList("Electronics", "Mobile")));
     catalog.addProduct(103, "Headphones", 199.99, new HashSet<>(Arrays.asList("Audio", "Accessories")));
     catalog.addProduct(104, "Chair", 89.99, new HashSet<>(Arrays.asList("Furniture")));

     System.out.println("\nProducts sorted by price (ascending):");
     catalog.listProductsSortedByPrice(true);

     System.out.println("\nProducts sorted by price (descending):");
     catalog.listProductsSortedByPrice(false);

     System.out.println("\nProducts in price range $100 - $800:");
     catalog.searchProductsByPriceRange(100, 800);
 }
}
