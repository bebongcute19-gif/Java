package BTVN01;

public class Person {
    private String name;
    private String email;
    private String phone;

    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void display() {
        System.out.println(
                "Tên: " + name +
                        ", Email: " + email +
                        ", Số điện thoại: " + phone
        );
    }
}
