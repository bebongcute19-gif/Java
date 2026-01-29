package BTVN05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Upcasting - Runtime polymorphism
        Animal dog = new Dog("Buddy", 3);
        Animal cat = new Cat("Kitty", 2);
        Animal elephant = new Elephant("Dumbo", 10);

        int choice;
        do {
            System.out.println("\n===== ZOO MANAGEMENT =====");
            System.out.println("1. Hiển thị thông tin Dog");
            System.out.println("2. Hiển thị thông tin Cat");
            System.out.println("3. Hiển thị thông tin Elephant");
            System.out.println("4. Kiểm tra đa hình runtime (makeSound)");
            System.out.println("5. Kiểm tra overloading (eat)");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    dog.showInfo();
                    ((Dog) dog).fetchBall(); // downcasting
                    break;

                case 2:
                    cat.showInfo();
                    ((Cat) cat).climbTree();
                    break;

                case 3:
                    elephant.showInfo();
                    ((Elephant) elephant).sprayWater();
                    break;

                case 4:
                    System.out.println("=== Runtime Polymorphism ===");
                    dog.makeSound();
                    cat.makeSound();
                    elephant.makeSound();
                    break;

                case 5:
                    System.out.println("=== Compile-time Polymorphism ===");
                    dog.eat();
                    dog.eat("meat");
                    break;

                case 0:
                    System.out.println("Thoát chương trình 👋");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);

        sc.close();

    }
}
