package BTVN05;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENU SINH VIÊN =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. In danh sách sinh viên");
            System.out.println("3. Tìm sinh viên GPA cao nhất");
            System.out.println("4. In tổng số sinh viên đã tạo");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số sinh viên: ");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Sinh viên " + (i + 1));
                        Student s = new Student();
                        s.input();
                        students.add(s);
                    }
                    break;

                case 2:
                    System.out.println("Danh sách sinh viên:");
                    for (Student s : students) {
                        s.print();
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("Danh sách rỗng!");
                        break;
                    }
                    double maxGpa = students.get(0).getGpa();
                    for (Student s : students) {
                        if (s.getGpa() > maxGpa) {
                            maxGpa = s.getGpa();
                        }
                    }
                    System.out.println("Sinh viên GPA cao nhất:");
                    for (Student s : students) {
                        if (s.getGpa() == maxGpa) {
                            s.print();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Tổng số sinh viên đã tạo: "
                            + Student.getTotalStudent());
                    break;

                case 0:
                    System.out.println("Thoát chương trình!");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
