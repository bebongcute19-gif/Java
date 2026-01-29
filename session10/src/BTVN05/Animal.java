package BTVN05;

public class Animal {
    protected String name;
    protected Integer age;
    public Animal(String name, Integer age) {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public void showInfo() {
        System.out.println(name);
        System.out.println(age);
    }
    public void makeSound() {
        System.out.println("I'm a sound");
    }
    public void eat() {
        System.out.println(name + " is eating");
    }

    public void eat(String food) {
        System.out.println(name + " is eating " + food);
    }
}
