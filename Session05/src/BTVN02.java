public class BTVN02 {
    public static void main(String[] args) {
        final int LOOP = 1_000_000; // 1 triệu lần

        // ===== 1. String =====
        String str = "Hello";
        long start = System.currentTimeMillis();

        for (int i = 0; i < LOOP; i++) {
            str += " World";
        }

        long end = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với String: " + (end - start) + " ms");


        // ===== 2. StringBuilder =====
        StringBuilder sb = new StringBuilder("Hello");
        start = System.currentTimeMillis();

        for (int i = 0; i < LOOP; i++) {
            sb.append(" World");
        }

        end = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuilder: " + (end - start) + " ms");


        // ===== 3. StringBuffer =====
        StringBuffer sbf = new StringBuffer("Hello");
        start = System.currentTimeMillis();

        for (int i = 0; i < LOOP; i++) {
            sbf.append(" World");
        }

        end = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuffer: " + (end - start) + " ms");


        // ===== Nhận xét =====
        System.out.println("\nNhận xét:");
        System.out.println("- String: Không hiệu quả cho phép nối chuỗi nhiều lần do tạo ra nhiều đối tượng mới.");
        System.out.println("- StringBuilder: Hiệu quả và nhanh chóng, thích hợp cho nối chuỗi trong một luồng.");
        System.out.println("- StringBuffer: Tương tự StringBuilder nhưng an toàn đa luồng, tốc độ chậm hơn một chút do đồng bộ.");
    }

}
