package BTVN03;

import BTVN02.Asset;

public class FruitTea extends Drink {

    public FruitTea(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.println("Prepare: Lắc với đá và trái cây tươi");
    }
}
