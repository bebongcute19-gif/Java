package BTVN02;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AssetManager manager = new AssetManager();

        while (true) {
            System.out.println("===== ASSET MANAGEMENT =====");
            System.out.println("1. Add asset");
            System.out.println("2. Show report");
            System.out.println("3. Search asset");
            System.out.println("4. Update purchase price");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.println("1. Computer");
                    System.out.println("2. Network Device");
                    int type = Integer.parseInt(sc.nextLine());

                    System.out.print("Code: ");
                    String code = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Purchase Price: ");
                    double price = Double.parseDouble(sc.nextLine());

                    if (type == 1) {
                        System.out.print("RAM: ");
                        int ram = Integer.parseInt(sc.nextLine());
                        System.out.print("CPU: ");
                        String cpu = sc.nextLine();
                        manager.addAsset(new Computer(code, name, price, ram, cpu));
                    } else {
                        System.out.print("Ports: ");
                        int ports = Integer.parseInt(sc.nextLine());
                        manager.addAsset(new NetworkDevice(code, name, price, ports));
                    }
                }
                case 2 -> manager.displayAll();

                case 3 -> {
                    System.out.println("1. Search by code");
                    System.out.println("2. Search by price");
                    int t = Integer.parseInt(sc.nextLine());

                    if (t == 1) {
                        System.out.print("Enter code: ");
                        Asset a = manager.search(sc.nextLine());
                        if (a != null) a.display();
                        else System.out.println("Not found!");
                    } else {
                        System.out.print("Enter max price: ");
                        for (Asset a : manager.search(Double.parseDouble(sc.nextLine()))) {
                            a.display();
                        }
                    }
                }
                case 4 -> {
                    System.out.print("Enter asset code: ");
                    Asset a = manager.search(sc.nextLine());
                    if (a != null) {
                        System.out.print("New price: ");
                        a.setPurchasePrice(Double.parseDouble(sc.nextLine()));
                    }
                }
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
            }
        }
    }
}
