package demo1;
import java.util.stream.IntStream;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
    /*taoọ 1 danh sách ngẫu nhiên 100 số từ 0 tới 100 có trùng
    duyệt và tìm ra các số nguyên tố trong danh sách
    2. duyệt và tính tổng tất cả các số chia hết cho 3
     3. đếm số lần xuất hiện của giá trị 10 trong danh sách
     4 kiểm tra tồn taiị của giá trị 50 trong danh sách.
     sử dụng stream
     */

    public static void main(String[] args) {

        // 1. Tạo danh sách ngẫu nhiên 100 số từ 0 đến 100 (có trùng)
        Random random = new Random();
        List<Integer> numbers = random.ints(100, 0, 101)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Danh sách số:");
        System.out.println(numbers);

        // 2. Tìm các số nguyên tố
        List<Integer> primeNumbers = numbers.stream()
                .filter(Main::isPrime)
                .collect(Collectors.toList());

        System.out.println("\nCác số nguyên tố:");
        System.out.println(primeNumbers);

        // 3. Tính tổng các số chia hết cho 3
        int sumDivisibleBy3 = numbers.stream()
                .filter(n -> n % 3 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("\nTổng các số chia hết cho 3: " + sumDivisibleBy3);

        // 4. Đếm số lần xuất hiện của giá trị 10
        long count10 = numbers.stream()
                .filter(n -> n == 10)
                .count();

        System.out.println("\nSố lần xuất hiện của số 10: " + count10);

        // 5. Kiểm tra tồn tại của giá trị 50
        boolean exists50 = numbers.stream()
                .anyMatch(n -> n == 50);

        System.out.println("\nDanh sách có chứa số 50 không? " + exists50);
    }

    // Hàm kiểm tra số nguyên tố
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .allMatch(i -> n % i != 0);
    }
}
