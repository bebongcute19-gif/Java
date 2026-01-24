package BTVN06;

import java.util.Scanner;

public class Product {private int id;
    private String name;
    private double price;

    // Static
    private static int AUTO_ID = 1;

    // Final
    public static final String WAREHOUSE_CODE = "KHO-01";

    // Constructor không tham số
    public Product() {
        this.id = AUTO_ID++;
    }

    // Constructor có tham số
    public Product(String name, double price) {
        this(); // gọi constructor không tham số
        this.name = name;
        this.price = price;
    }

    // Nhập thông tin
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm: ");
        name = sc.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        price = sc.nextDouble();
    }

    // In thông tin
    public void print() {
        System.out.printf("ID: %d | Tên: %s | Giá: %.2f | Kho: %s%n",
                id, name, price, WAREHOUSE_CODE);
    }

    // Getter
    public double getPrice() {
        return price;
    }

    // Getter ID (dùng khi cần)
    public int getId() {
        return id;
    }

}
