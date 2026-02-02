package BTVN03;
import java.util.ArrayList;
public class DrinkManager {
    private ArrayList<Drink> menu = new ArrayList<>();

    public void addDrink(Drink d) {
        menu.add(d);
    }

    public void showMenu() {
        for (Drink d : menu) {
            d.display(); // Polymorphism
        }
    }

    public void applyDiscountAll(double percent) {
        for (Drink d : menu) {
            d.applyDiscount(percent);
        }
    }

    public void removeById(int id) {
        menu.removeIf(d -> d.getId() == id);
    }

    public double averagePrice() {
        if (menu.isEmpty()) return 0;
        double sum = 0;
        for (Drink d : menu) {
            sum += d.getPrice();
        }
        return sum / menu.size();
    }
}
