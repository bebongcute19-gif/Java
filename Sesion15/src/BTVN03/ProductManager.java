package BTVN03;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Thêm sản phẩm thành công.");
    }

    public void removeProduct(int id) {
        boolean removed = products.removeIf(p -> p.getId() == id);
        if (!removed) {
            throw new RuntimeException("Không tìm thấy sản phẩm để xóa");
        }
        System.out.println("Xóa sản phẩm thành công.");
    }

    public Product findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại"));
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }
        products.forEach(System.out::println);
    }
}