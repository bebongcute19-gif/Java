package re.exception;

public class MyUncheckedException extends RuntimeException {
    public MyUncheckedException() {

    }
    public MyUncheckedException(String msg) {
        super(msg);
    }
}
