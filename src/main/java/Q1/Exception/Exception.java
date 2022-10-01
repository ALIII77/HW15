package Q1.Exception;

public class Exception extends  RuntimeException {

    public Exception(String message) {
        super(message);
    }

    public Exception(Throwable cause) {
        super(cause);
    }
}
