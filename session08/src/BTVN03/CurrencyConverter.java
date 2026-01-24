package BTVN03;

import java.text.DecimalFormat;

public class CurrencyConverter {
    // Tỉ giá toàn cục (VND -> USD)
    private static double rate = 0;

    // Không cho tạo đối tượng (utility class)
    private CurrencyConverter() {
    }

    // Đặt tỉ giá
    public static void setRate(double r) {
        if (r <= 0) {
            System.out.println("Tỉ giá không hợp lệ!");
            return;
        }
        rate = r;
    }

    // Lấy tỉ giá hiện tại (optional)
    public static double getRate() {
        return rate;
    }

    // Chuyển đổi VND -> USD
    public static double toUSD(int vnd) {
        if (rate <= 0) {
            System.out.println("Chưa thiết lập tỉ giá!");
            return 0;
        }
        if (vnd < 0) {
            System.out.println("Số tiền VND không hợp lệ!");
            return 0;
        }
        return vnd / rate;
    }

    // Format USD (2 chữ số thập phân, có dấu phân cách)
    public static String formatUSD(double usd) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(usd);
    }

    // Test nhanh trong main
    public static void main(String[] args) {
        CurrencyConverter.setRate(25000); // 1 USD = 25,000 VND

        int vnd = 1_000_000;
        double usd = CurrencyConverter.toUSD(vnd);

        System.out.println("VND: " + vnd);
        System.out.println("USD: " + CurrencyConverter.formatUSD(usd));
    }
}
