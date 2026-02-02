package BTVN01;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static ArrayList<Staff> staffList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("===== STAFF MANAGEMENT =====");
            System.out.println("1. Add new staff");
            System.out.println("2. Show staff list");
            System.out.println("3. Update staff by ID");
            System.out.println("4. Delete staff by ID");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addStaff();
                case 2 -> showStaff();
                case 3 -> updateStaff();
                case 4 -> deleteStaff();
                case 5 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // 1. Add
    static void addStaff() {
        System.out.println("1. Lecturer");
        System.out.println("2. Admin Staff");
        System.out.print("Choose type: ");
        int type = Integer.parseInt(sc.nextLine());

        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Base Salary: ");
        double baseSalary = Double.parseDouble(sc.nextLine());

        if (type == 1) {
            System.out.print("Teaching Hours: ");
            int hours = Integer.parseInt(sc.nextLine());
            staffList.add(new Lecturer(id, name, baseSalary, hours));
        } else {
            System.out.print("Bonus: ");
            double bonus = Double.parseDouble(sc.nextLine());
            staffList.add(new AdminStaff(id, name, baseSalary, bonus));
        }
    }

    // 2. Show
    static void showStaff() {
        for (Staff s : staffList) {
            s.displayInfo(); // Runtime Polymorphism
        }
    }

    // 3. Update
    static void updateStaff() {
        System.out.print("Enter ID to update: ");
        int id = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getId() == id) {
                System.out.print("New name: ");
                String name = sc.nextLine();
                System.out.print("New base salary: ");
                double baseSalary = Double.parseDouble(sc.nextLine());

                Staff old = staffList.get(i);

                if (old instanceof Lecturer) {
                    System.out.print("New teaching hours: ");
                    int hours = Integer.parseInt(sc.nextLine());
                    staffList.set(i, new Lecturer(id, name, baseSalary, hours));
                } else {
                    System.out.print("New bonus: ");
                    double bonus = Double.parseDouble(sc.nextLine());
                    staffList.set(i, new AdminStaff(id, name, baseSalary, bonus));
                }
                return;
            }
        }
        System.out.println("Staff not found!");
    }

    // 4. Delete
    static void deleteStaff() {
        System.out.print("Enter ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        staffList.removeIf(s -> s.getId() == id);
    }
}
