package BTVN03;

public class Invoice {
    private String code;
    private double amount;

    public Invoice(String code, double amount) {
        this.code = code;
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public double getAmount() {
        return amount;
    }

    public void display(int id) {
        System.out.println("ID: " + id +
                ", Mã hóa đơn: " + code +
                ", Số tiền: " + amount);
    }
}