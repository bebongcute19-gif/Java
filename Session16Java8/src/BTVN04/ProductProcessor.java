package BTVN04;

import java.util.List;

public interface ProductProcessor {

    // abstract method
    double calculateTotalValue(List<Product> products);

    // static method
    static void printProductList(List<Product> products) {
        products.forEach(System.out::println);
    }

    // default method
    default boolean hasExpensiveProduct(List<Product> products) {
        return products.stream()
                .anyMatch(p -> p.getPrice() > 100);
    }
}