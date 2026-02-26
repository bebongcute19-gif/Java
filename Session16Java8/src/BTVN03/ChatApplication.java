package BTVN03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatApplication {

    private static List<Message> messages = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {

        while (true) {
            System.out.print("\nNhập tên người gửi (hoặc 'exit' để thoát): ");
            String sender = scanner.nextLine().trim();

            if (sender.equalsIgnoreCase("exit")) {
                break;
            }

            if (sender.isEmpty()) {
                System.out.println("Tên người gửi không được để trống!");
                continue;
            }

            System.out.print("Nhập nội dung tin nhắn: ");
            String content = scanner.nextLine();

            messages.add(new Message(sender, content, LocalDateTime.now()));

            System.out.println(
                    "Nhập 'history' để xem lịch sử, " +
                            "hoặc 'filter' để lọc tin nhắn theo người gửi, " +
                            "hoặc 'date' để lọc theo ngày:"
            );

            String option = scanner.nextLine().trim();

            switch (option) {
                case "history" -> showHistory();
                case "filter" -> filterBySender();
                case "date" -> filterByDate();
                default -> System.out.println("Quay lại chat...");
            }
        }
    }

    // 4. Xem lịch sử chat
    private static void showHistory() {
        if (messages.isEmpty()) {
            System.out.println("Chưa có tin nhắn nào.");
            return;
        }
        messages.forEach(System.out::println);
    }

    // 5. Lọc theo người gửi (Streams)
    private static void filterBySender() {
        System.out.print("Nhập tên người gửi để lọc: ");
        String name = scanner.nextLine();

        messages.stream()
                .filter(m -> m.getSender().equalsIgnoreCase(name))
                .forEach(System.out::println);
    }

    // 6. Lọc theo ngày (Streams + try/catch)
    private static void filterByDate() {
        try {
            System.out.print("Nhập ngày (dd/MM/yyyy): ");
            String input = scanner.nextLine();
            LocalDate date = LocalDate.parse(input, DATE_FORMAT);

            messages.stream()
                    .filter(m -> m.getTimestamp().toLocalDate().equals(date))
                    .forEach(System.out::println);

        } catch (DateTimeParseException e) {
            System.out.println("Sai định dạng ngày!");
        }
    }
}
