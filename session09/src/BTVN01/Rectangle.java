package BTVN01;

public class Rectangle {private double width;
    private double height;

    // 2. Constructor không tham số
    public Rectangle() {
    }

    // 3. Constructor có tham số
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // 4. Phương thức tính diện tích
    public double getArea() {
        return width * height;
    }

    // 5. Phương thức tính chu vi
    public double getPerimeter() {
        return (width + height) * 2;
    }

    // 6. Phương thức in thông tin (optional)
    public void printInfo() {
        System.out.println("Chiều rộng: " + width);
        System.out.println("Chiều cao: " + height);
        System.out.println("Diện tích: " + getArea());
        System.out.println("Chu vi: " + getPerimeter());
    }
}
