package exceptions;

public class AmountExceededException extends RuntimeException {
    public AmountExceededException(String msg) {
        super(msg);
    }
}
