package BTVN06;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        // Tạo sẵn dữ liệu
        vehicles.add(new Car("Toyota", 2020, "Gasoline"));
        vehicles.add(new Motorcycle("Honda", 2018, "Gasoline"));
        vehicles.add(new Truck("Volvo", 2022, "Diesel"));

        int choice;

        do {
            System.out.println("========== VEHICLE MANAGEMENT MENU ==========");
            System.out.println("1. Hiển thị thông tin tất cả phương tiện");
            System.out.println("2. Kiểm tra Overriding: startEngine()");
            System.out.println("3. Kiểm tra Overloading: move()");
            System.out.println("4. Kiểm tra đa hình runtime");
            System.out.println("5. Gọi hành vi đặc trưng của từng loại");
            System.out.println("6. Thêm phương tiện mới");
            System.out.println("0. Thoát");
            System.out.println("============================================");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- THÔNG TIN PHƯƠNG TIỆN ---");
                    for (Vehicle v : vehicles) {
                        v.showInfo();
                    }
                    break;

                case 2:
                    System.out.println("\n--- OVERRIDING: startEngine() ---");
                    for (Vehicle v : vehicles) {
                        v.startEngine();
                    }
                    break;

                case 3:
                    System.out.println("\n--- OVERLOADING: move() ---");
                    vehicles.get(0).move();
                    vehicles.get(0).move(80);
                    break;

                case 4:
                    System.out.println("\n--- POLYMORPHISM RUNTIME ---");
                    for (Vehicle v : vehicles) {
                        v.startEngine();
                    }
                    break;

                case 5:
                    System.out.println("\n--- HÀNH VI ĐẶC TRƯNG TỪNG LOẠI ---");
                    for (Vehicle v : vehicles) {
                        if (v instanceof Car) {
                            ((Car) v).openTrunk();
                        } else if (v instanceof Motorcycle) {
                            ((Motorcycle) v).doWheelie();
                        } else if (v instanceof Truck) {
                            ((Truck) v).loadCargo();
                        }
                    }
                    break;

                case 6:
                    System.out.print("Loại (car/motorcycle/truck): ");
                    String type = sc.nextLine();
                    System.out.print("Brand: ");
                    String brand = sc.nextLine();
                    System.out.print("Year: ");
                    int year = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Fuel Type: ");
                    String fuel = sc.nextLine();

                    if (type.equalsIgnoreCase("car")) {
                        vehicles.add(new Car(brand, year, fuel));
                    } else if (type.equalsIgnoreCase("motorcycle")) {
                        vehicles.add(new Motorcycle(brand, year, fuel));
                    } else if (type.equalsIgnoreCase("truck")) {
                        vehicles.add(new Truck(brand, year, fuel));
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình...");
                    break;
            }
        } while (choice != 0);
    }
}
