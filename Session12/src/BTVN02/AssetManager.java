package BTVN02;
import java.util.ArrayList;
public class AssetManager {
    private ArrayList<Asset> assets = new ArrayList<>();

    public void addAsset(Asset a) {
        assets.add(a);
    }

    // Tìm theo assetCode
    public Asset search(String assetCode) {
        for (Asset a : assets) {
            if (a.getAssetCode().equalsIgnoreCase(assetCode)) {
                return a;
            }
        }
        return null;
    }

    // Tìm theo purchasePrice
    public ArrayList<Asset> search(double maxPrice) {
        ArrayList<Asset> result = new ArrayList<>();
        for (Asset a : assets) {
            if (a.getPurchasePrice() < maxPrice) {
                result.add(a);
            }
        }
        return result;
    }

    public void displayAll() {
        for (Asset a : assets) {
            a.display();
        }
    }
}
