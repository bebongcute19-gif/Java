package BTVN02;

public class NetworkDevice extends Asset{
    private int numberOfPorts;

    public NetworkDevice(String assetCode, String name, double purchasePrice, int numberOfPorts) {
        super(assetCode, name, purchasePrice);
        this.numberOfPorts = numberOfPorts;
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * 0.9;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Ports: " + numberOfPorts);
        System.out.println("----------------------");
    }
}
