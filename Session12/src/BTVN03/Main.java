package BTVN03;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DrinkManager manager = new DrinkManager();

        while (true) {
            System.out.println("===== COFFEE SHOP MENU =====");
            System.out.println("1. Add drink");
            System.out.println("2. Show menu");
            System.out.println("3. Apply discount");
            System.out.println("4. Remove drink");
            System.out.println("5. Average price");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.println("1. Coffee");
                    System.out.println("2. Fruit Tea");
                    int type = Integer.parseInt(sc.nextLine());

                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Price: ");
                    double price = Double.parseDouble(sc.nextLine());

                    if (type == 1)
                        manager.addDrink(new Coffee(id, name, price));
                    else
                        manager.addDrink(new FruitTea(id, name, price));
                }
                case 2 -> manager.showMenu();

                case 3 -> {
                    System.out.print("Discount (%): ");
                    manager.applyDiscountAll(Double.parseDouble(sc.nextLine()));
                }
                case 4 -> {
                    System.out.print("Enter ID: ");
                    manager.removeById(Integer.parseInt(sc.nextLine()));
                }
                case 5 -> {
                    System.out.println("Average price: " + manager.averagePrice());
                }
                case 6 -> {
                    System.out.println("Bye!");
                    return;
                }
            }
        }
    }
}
