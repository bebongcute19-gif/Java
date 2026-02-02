package BTVN02;

public abstract class Asset {
    protected String assetCode;
    protected String name;
    protected double purchasePrice;

    public Asset(String assetCode, String name, double purchasePrice) {
        this.assetCode = assetCode;
        this.name = name;
        this.purchasePrice = purchasePrice;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public abstract double getMarketValue();

    public void display() {
        System.out.println("Code: " + assetCode);
        System.out.println("Name: " + name);
        System.out.println("Purchase Price: " + purchasePrice);
        System.out.println("Market Value: " + getMarketValue());
    }
}
