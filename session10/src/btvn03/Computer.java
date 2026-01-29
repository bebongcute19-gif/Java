package btvn03;

public class Computer {
    public double calculatePrice(double basePrice){
        System.out.println("using base price: " + basePrice);
        return basePrice;
    }
    public double calculatePrice(double basePrice, double tax){
        System.out.println("using base price+ tax: " + (basePrice+tax));
        return basePrice+ tax;
    }
    public double calculatePrice(double basePrice, double tax, double discount){
        System.out.println("using base price+ tax+ discount: " + (basePrice+tax-discount));
        return basePrice+ tax- discount;
    }
}
