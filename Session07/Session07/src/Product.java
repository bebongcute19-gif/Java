import java.util.Scanner;

public class Product {
    String id;
    String name;
    String details;
    Double price;
    Integer quantity;
    Boolean status;
    public Product() {
    }
    public Product(String id, String name, String details, Double price, Integer quantity, Boolean status) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }
    public void inputData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã sản phẩm: ");
        id = sc.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        name = sc.nextLine();

        System.out.print("Nhập mô tả: ");
        details = sc.nextLine();

        System.out.print("Nhập giá tiền: ");
        price = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập tồn kho: ");
        quantity = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập trạng thái (true = hiện, false = ẩn): ");
        status = Boolean.parseBoolean(sc.nextLine());
    }

    // ===== Phương thức hiển thị thông tin =====
    public void displayInfo() {
        System.out.println("----- THÔNG TIN SẢN PHẨM -----");
        System.out.println("Mã sản phẩm: " + id);
        System.out.println("Tên sản phẩm: " + name);
        System.out.println("Mô tả: " + details);
        System.out.println("Giá tiền: " + price);
        System.out.println("Tồn kho: " + quantity);
        System.out.println("Trạng thái: " + (status ? "Hiện" : "Ẩn"));
    }
    public Product createProduct() {
        return this;
    }

}
