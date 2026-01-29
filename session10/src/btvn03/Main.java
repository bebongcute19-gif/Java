package btvn03;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();
        double price1 = computer.calculatePrice(1000);
        System.out.println("Final price " + price1);
        double price2 = computer.calculatePrice(1000,100);
        System.out.println("Final price " + price2);
        double price3 = computer.calculatePrice(1000,100,50);
        System.out.println("Final price " + price3);
    }
}
