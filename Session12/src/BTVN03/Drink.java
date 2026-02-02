package BTVN03;

import BTVN02.Asset;

public abstract class Drink implements IPromotion {
    private int id;
    private String name;
    private double price;

    public Drink(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Encapsulation
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    // Giảm giá dùng chung
    @Override
    public void applyDiscount(double percentage) {
        price = price - price * percentage / 100;
    }

    // Đa hình
    public abstract void prepare();

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        prepare();
        System.out.println("Price: " + price);
        System.out.println("--------------------");
    }
}
