package BTVN03;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student(1, "Nguyễn Văn A", 20, 3.2);
        Student s2 = new Student(2, "Trần Thị B", 21, 3.8);
        Student s3 = new Student(3, "Lê Văn C", 19, 2.5);

        // In thông tin từng sinh viên
        s1.printInfo();
        s2.printInfo();
        s3.printInfo();

        // In tổng số sinh viên
        System.out.println("Tổng số sinh viên: " + Student.getCount());
    }
}
