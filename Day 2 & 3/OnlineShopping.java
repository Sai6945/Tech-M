package Day2and3;

abstract class Product {
    protected double price;

    public Product(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();
}

class Electronics extends Product {
    public Electronics(double price) {
        super(price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10; // 10% discount
    }
}

class Clothing extends Product {
    public Clothing(double price) {
        super(price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.05; // 5% discount
    }
}

public class OnlineShopping {
    public static void main(String[] args) {
        Product phone = new Electronics(50000);
        Product shirt = new Clothing(2000);

        System.out.println("Phone Discount: " + phone.calculateDiscount());
        System.out.println("Shirt Discount: " + shirt.calculateDiscount());
    }
}
