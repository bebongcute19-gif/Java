package BTVN05;

import btvn04.Car;

public class Elephant extends Mammal {
    public Elephant(String name, int age) {
        super(name, age, false);
    }

    @Override
    public void makeSound() {
        System.out.println("Elephant trumpets: Prrr!");
    }

    public void sprayWater() {
        System.out.println(name + " is spraying water 💦");
    }
}
