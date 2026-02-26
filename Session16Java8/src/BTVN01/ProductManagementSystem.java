package BTVN01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductManagementSystem {

    private static Map<Integer, Product> productMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            showMenu();
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> editProduct();
                case 3 -> deleteProduct();
                case 4 -> displayProducts();
                case 5 -> filterProducts();
                case 6 -> totalValue();
                case 0 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\n--- Product Management System ---");
        System.out.println("1. Add Product");
        System.out.println("2. Edit Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Display Products");
        System.out.println("5. Filter Products (Price > 100)");
        System.out.println("6. Total Value of Products");
        System.out.println("0. Exit");
    }

    // 1. Thêm sản phẩm
    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (productMap.containsKey(id)) {
            System.out.println("Product ID already exists!");
            return;
        }

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Product Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        productMap.put(id, new Product(id, name, price));
        System.out.println("Product added successfully.");
    }

    // 2. Sửa sản phẩm
    private static void editProduct() {
        System.out.print("Enter Product ID to edit: ");
        int id = Integer.parseInt(scanner.nextLine());

        Product product = productMap.get(id);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter new Product Name: ");
        product.setName(scanner.nextLine());

        System.out.print("Enter new Product Price: ");
        product.setPrice(Double.parseDouble(scanner.nextLine()));

        System.out.println("Product updated successfully.");
    }

    // 3. Xóa sản phẩm
    private static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (productMap.remove(id) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // 4. Hiển thị sản phẩm
    private static void displayProducts() {
        if (productMap.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        productMap.values().forEach(p ->
                System.out.println("ID: " + p.getId()
                        + ", Name: " + p.getName()
                        + ", Price: " + p.getPrice())
        );
    }

    // 5. Lọc sản phẩm price > 100 (Streams)
    private static void filterProducts() {
        System.out.println("Products with price greater than 100:");
        productMap.values().stream()
                .filter(p -> p.getPrice() > 100)
                .forEach(p ->
                        System.out.println("ID: " + p.getId()
                                + ", Name: " + p.getName()
                                + ", Price: " + p.getPrice())
                );
    }

    // 6. Tính tổng giá trị sản phẩm (Streams)
    private static void totalValue() {
        double total = productMap.values().stream()
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println("Total value of products: " + total);
    }
}