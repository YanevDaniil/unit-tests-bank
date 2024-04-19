package exception;

public class AmountOutOfRangeException extends RuntimeException {

    // String message = super.getMessage();
    public AmountOutOfRangeException(String message) {
        super(message);
    }
}
