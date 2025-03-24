package Day2and3;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            Product p = (Product) obj;
            return this.name.equals(p.name) && this.price == p.price;
        }
        return false;
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Laptop", 50000);
        System.out.println(p1.equals(p2)); // true
    }
}
