import java.util.Scanner;

public class Calculator {
    int count = 0;
    static int number = 10;
    static int sum(int a, int b) {
        return a + b;
    }
    public final void display() {
        //phương thức không thể bị ghi đr=eg
    }
    public static void main(String[] args) {
        System.out.println(number);
        Calculator calculator = new Calculator();
        Calculator calculator1 = new Calculator();
        calculator1.number = 100;
        System.out.println(calculator.number);
        System.out.println(calculator1.number);
        System.out.println(Calculator.number);
        System.out.println(Calculator.sum(2,3));
    }
}
