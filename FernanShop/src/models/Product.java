package models;

public class Product {

    //Atributos
    private String code;
    private String name;
    private int stock;
    private double price;


    //Constructor
    public Product(String code, String name, int stock, double price) {
        this.code = code;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public Product(Product product) {

    }

    //Getters y Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Otros métodos
    public boolean removeStock(int amount) {
        if (amount < 0 || amount > stock) return false;
        stock -= amount;
        return true;
    }

    public boolean increaseStock(int amount) {
        if (amount < 0) return false;
        stock += amount;
        return true;
    }


    //toString

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
