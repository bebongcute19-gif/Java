package BTVN02;

public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("ID : " + id + ", Tên sinh viên: " + name);
    }
}