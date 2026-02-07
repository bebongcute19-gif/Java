package btvn04;

import java.util.*;

public class PhoneNumberValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> validPhones = new ArrayList<>();
        Map<String, String> invalidPhones = new LinkedHashMap<>();

        System.out.println("Nhập danh sách số điện thoại (ngăn cách bằng dấu ,):");
        String input = scanner.nextLine();

        String[] phones = input.split(",");

        for (String phone : phones) {
            phone = phone.trim();

            try {
                InvalidPhoneNumberLengthException.validatePhoneNumber(phone);
                validPhones.add(phone);
            } catch (InvalidPhoneNumberLengthException e) {
                invalidPhones.put(phone, e.getMessage());
            }
        }

        // Hiển thị kết quả
        System.out.println("\nSố điện thoại hợp lệ:");
        for (String phone : validPhones) {
            System.out.println("- " + phone);
        }

        System.out.println("\nSố điện thoại không hợp lệ:");
        for (Map.Entry<String, String> entry : invalidPhones.entrySet()) {
            System.out.println("- " + entry.getKey() + " : " + entry.getValue());
        }

        scanner.close();
    }
}
