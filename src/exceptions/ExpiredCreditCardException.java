package exceptions;

public class ExpiredCreditCardException extends RuntimeException {
    public ExpiredCreditCardException(String msg) {
        super(msg);
    }
}
