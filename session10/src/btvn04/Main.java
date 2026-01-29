package btvn04;

public class Main
{
    public static void main(String[] args) {
        Car car = new Car();

        car.accelerate();
        car.printStatus();

        car.accelerate(20);
        car.printStatus();

        car.accelerate(10, 2);
        car.printStatus();
    }
}
