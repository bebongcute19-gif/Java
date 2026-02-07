package re.exception;

public class MyCheckdException extends Exception {
    //Ngoại lệ exception
    int code;
    String msg;
    public MyCheckdException(int code, String msg) {
        super(msg);
        return;
    }
}
