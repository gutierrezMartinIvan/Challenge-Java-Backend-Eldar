package exceptions;

public class InvalidCardHolderException extends RuntimeException {
    public InvalidCardHolderException(String msg) {
        super(msg);
    }
}
