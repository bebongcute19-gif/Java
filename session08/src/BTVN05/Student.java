package BTVN05;

import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private double gpa;

    // static: đếm tổng số sinh viên
    private static int countStudent = 0;

    // hằng số cho mỗi đối tượng
    public final double SCORE_FACTOR = 0.25;

    // ===== Constructor =====
    // Không tham số
    public Student() {
        countStudent++;
    }

    // Có 3 tham số (constructor chaining)
    public Student(int id, String name, double gpa) {
        this(); // gọi constructor không tham số
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // ===== Phương thức =====
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã SV: ");
        id = sc.nextInt();
        sc.nextLine(); // clear buffer
        System.out.print("Nhập họ tên: ");
        name = sc.nextLine();
        System.out.print("Nhập GPA: ");
        gpa = sc.nextDouble();
    }

    public void print() {
        System.out.println(
                "ID: " + id +
                        ", Name: " + name +
                        ", GPA: " + gpa +
                        ", Quy đổi: " + (gpa * SCORE_FACTOR)
        );
    }

    public double getGpa() {
        return gpa;
    }

    public static int getTotalStudent() {
        return countStudent;
    }
}
