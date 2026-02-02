package BTVN03;

import BTVN02.Asset;

public class Coffee extends Drink {
    public Coffee(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.println("Prepare: Pha bằng máy");
    }
}
