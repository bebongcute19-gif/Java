package btvn04;

public class InvalidPhoneNumberLengthException extends Exception {

    public InvalidPhoneNumberLengthException(String message) {
        super(message);
    }

    public static void validatePhoneNumber(String phone)
            throws InvalidPhoneNumberLengthException {

        // Kiểm tra độ dài
        if (phone.length() != 10) {
            throw new InvalidPhoneNumberLengthException("Sai độ dài (phải đúng 10 chữ số)");
        }

        // Kiểm tra ký tự không hợp lệ
        if (!phone.matches("\\d+")) {
            if (phone.contains(" ")) {
                throw new InvalidPhoneNumberLengthException("Không được chứa khoảng trắng");
            } else {
                throw new InvalidPhoneNumberLengthException("Chứa ký tự không hợp lệ");
            }
        }
    }
}
