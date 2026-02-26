package BTVN02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventManagementSystem {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private static Scanner scanner = new Scanner(System.in);
    private static List<Event> events = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.print("Nhập tên sự kiện (hoặc 'exit' để thoát): ");
            String name = scanner.nextLine().trim();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            if (name.isEmpty()) {
                System.out.println("Can not enter empty string");
                continue;
            }

            LocalDateTime startDate = inputDateTime("Nhập thời gian bắt đầu (dd-MM-yyyy HH:mm): ");
            LocalDateTime endDate = inputDateTime("Nhập thời gian kết thúc (dd-MM-yyyy HH:mm): ");

            events.add(new Event(name, startDate, endDate));
        }

        displayEvents();
    }

    // Nhập LocalDateTime có bắt lỗi
    private static LocalDateTime inputDateTime(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                return LocalDateTime.parse(input, FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Enter not valid date");
            }
        }
    }

    // Hiển thị + kiểm tra trạng thái sự kiện
    private static void displayEvents() {
        System.out.println("\nDanh sách sự kiện:");
        LocalDateTime now = LocalDateTime.now();

        for (Event event : events) {
            String status;

            if (now.isBefore(event.getStartDate())) {
                status = "Sắp diễn ra";
            } else if (now.isAfter(event.getEndDate())) {
                status = "Đã kết thúc";
            } else {
                status = "Đang diễn ra";
            }

            System.out.println(
                    "Event{name='" + event.getName() +
                            "', startDate=" + event.getStartDate() +
                            ", endDate=" + event.getEndDate() +
                            ", status=" + status + "}"
            );
        }
    }
}