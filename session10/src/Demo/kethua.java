package Demo;

import java.util.Date;

public class kethua {
    private String name;
    private int age;
    private Boolean gender;
    private Date birthday;

    public kethua() {
    }
    public kethua(String name, int age, Boolean gender, Date birthday) {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
