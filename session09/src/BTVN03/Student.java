package BTVN03;

public class Student {
    private int id;
    private String fullName;
    private int age;
    private double gpa;

    // 2. Thuộc tính static
    private static int count = 0;

    // 3. Hằng số
    public static final double MIN_GPA = 0.0;
    public static final double MAX_GPA = 4.0;

    // 4. Constructor có tham số
    public Student(int id, String fullName, int age, double gpa) {

        this.id = id;
        this.fullName = fullName;
        this.age = age;

        // Kiểm tra GPA hợp lệ
        if (gpa >= MIN_GPA && gpa <= MAX_GPA) {
            this.gpa = gpa;
        } else {
            System.out.println("GPA không hợp lệ, gán mặc định 0.0");
            this.gpa = MIN_GPA;
        }

        // Tăng số lượng sinh viên
        count++;
    }

    // 5. Phương thức in thông tin
    public void printInfo() {
        System.out.println("ID       : " + id);
        System.out.println("Họ tên   : " + fullName);
        System.out.println("Tuổi     : " + age);
        System.out.println("GPA      : " + gpa);
        System.out.println("--------------------------");
    }

    // 6. Getter cho count
    public static int getCount() {
        return count;
    }
}
