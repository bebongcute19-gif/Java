package BTVN05;

public class Dog extends Mammal {
    public Dog(String name, int age) {
        super(name, age, true);
    }
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof woof!");
    }

    public void fetchBall() {
        System.out.println(name + " is fetching the ball 🦴");
    }

}
