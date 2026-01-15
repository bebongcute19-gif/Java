import java.util.Arrays;

public class SoNguyenTo {
    public static void main(String[] args) {


        boolean isPrime;

        int n = 2, i = 0;
        int[] primeList = new int[20];

        while (i < 20) {
            isPrime = true;
            for (int j = 2; j <= Math.sqrt(n); j++) {
                if (n % j == 0) {
                    isPrime = false;
                }
            }

            if (isPrime) {
                primeList[i] = n;
                i++;
            }

            n++;

        }

        System.out.println("Danh sách 20 số nguyên tố đầu tiên là: ");
        for (int j = 0; j < primeList.length; j++) {
            System.out.print(primeList[j] + " ");
        }

        Arrays.sort(primeList);

    }
}

