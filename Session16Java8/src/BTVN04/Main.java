package BTVN04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Tạo danh sách sản phẩm
        List<Product> products = new ArrayList<>();
        products.add(new Product("Bánh mì", 20));
        products.add(new Product("Cà phê", 50));
        products.add(new Product("Laptop", 1500));
        products.add(new Product("Tai nghe", 200));

        ProductProcessor processor = new ProductProcessorImpl();

        // Kiểm tra sản phẩm > 100
        if (processor.hasExpensiveProduct(products)) {
            System.out.println("Có sản phẩm đắt tiền (>100)");
        } else {
            System.out.println("Không có sản phẩm đắt tiền");
        }

        // Tính tổng giá trị sản phẩm
        double totalValue = processor.calculateTotalValue(products);
        System.out.println("Tổng giá trị sản phẩm: " + totalValue);

        // In danh sách sản phẩm
        System.out.println("\nDanh sách sản phẩm:");
        ProductProcessor.printProductList(products);
    }
}