package BTVN01;

public class Student {
    int id;
    String name;
    int age;

    // Constructor
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Hàm main
    public static void main(String[] args) {
        // Tạo đối tượng Student
        Student s1 = new Student(1, "Nguyen Van A", 20);

        // In thông tin sinh viên
        System.out.println("ID: " + s1.id
                + ", Name: " + s1.name
                + ", Age: " + s1.age);
    }
}
