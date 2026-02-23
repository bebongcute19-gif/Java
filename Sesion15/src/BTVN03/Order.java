package BTVN03;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private List<Product> products = new ArrayList<>();

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Đã thêm sản phẩm vào đơn hàng.");
    }

    public double getTotalPrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "Order{id=" + orderId +
                ", products=" + products +
                ", total=" + getTotalPrice() + '}';
    }
}