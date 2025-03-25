package models;

public class Product {
    private int id;
    private String name;
    private String discription; // Keeping the typo as is
    private double price;

    // Constructor
    public Product(int id, String name, String discription, double price) {
        this.id = id;
        this.name = name;
        this.discription = discription; // Keeping the typo as is
        this.price = price;
    }

    // Default Constructor (Required for JSP/Frameworks)
    public Product() {}

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDesc() { return discription; } // Keeping the typo as is
    public double getPrice() { return price; }

    // Setters (Optional)
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDesc(String discription) { this.discription = discription; } // Keeping the typo as is
    public void setPrice(double price) { this.price = price; }
}
