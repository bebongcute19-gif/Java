package BTVN03;
public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Giá sản phẩm phải > 0");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price + '}';
    }
}