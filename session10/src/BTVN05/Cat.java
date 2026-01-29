package BTVN05;

public class Cat extends Mammal {
    public Cat(String name, int age) {
        super(name, age, true);
    }

    @Override
    public void makeSound() {
        System.out.println("Cat meows: Meow meow!");
    }

    public void climbTree() {
        System.out.println(name + " is climbing a tree 🌳");
    }
}
