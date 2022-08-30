package exceptions;

public class InvalidIssuerException extends RuntimeException{
    public InvalidIssuerException(String msg) { super(msg); }
}
