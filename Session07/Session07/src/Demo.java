/* Lớp mô tả về sinh viên
THuộc tính: mã sinh viên, tên sinh viên, ngày sinh, sdt, email, giới tính
phương thức: nói ăn uống làm bài tập điểm danh
* */
public class Demo {
    String studentId;
    String name;
    String email;
    String dateOfBirth;
    String phoneNumber;
    SexEnum sex;
    public Demo() {
        //phuongw thuc khởi tạo không tam số , mặc định nếu không khai báo
    }
    public Demo(String studentId) {
        this.studentId = studentId;
    }

    public static void main(String[] args) {
        Demo s1 = new Demo();
        Demo s2 = new Demo("001");

    }
    //các phương thức khác
    public void eat(){
        System.out.println(name+" eating");
    }
    public void drink(){
        System.out.println("drinking");
    }
    public void talk(){
        System.out.println("talking");
    }
    public void doHomeWork(){
        System.out.println("doing home");
    }
    public void attendanceClass(){
        System.out.println("attendance class");
    }


}
