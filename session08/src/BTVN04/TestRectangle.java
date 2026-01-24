package BTVN04;

public class TestRectangle {
    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(3, 4);
        Rectangle r2 = new Rectangle(5, 2);
        Rectangle r3 = new Rectangle(4.5, 3.5);

        Rectangle[] rectangles = { r1, r2, r3 };

        System.out.println("Thông tin các hình chữ nhật:");
        for (Rectangle r : rectangles) {
            System.out.println(r);
        }

        // Tìm diện tích lớn nhất
        double maxArea = rectangles[0].getArea();
        for (Rectangle r : rectangles) {
            if (r.getArea() > maxArea) {
                maxArea = r.getArea();
            }
        }

        System.out.println("\nHình chữ nhật có diện tích lớn nhất:");
        for (Rectangle r : rectangles) {
            if (r.getArea() == maxArea) {
                System.out.println(r);
            }
        }
    }
}
