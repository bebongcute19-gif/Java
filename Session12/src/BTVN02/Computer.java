package BTVN02;

public class Computer extends Asset{
    private int ram;
    private String cpu;

    public Computer(String assetCode, String name, double purchasePrice, int ram, String cpu) {
        super(assetCode, name, purchasePrice);
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * 0.8;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("RAM: " + ram);
        System.out.println("CPU: " + cpu);
        System.out.println("----------------------");
    }
}
