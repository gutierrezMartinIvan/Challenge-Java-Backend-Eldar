package cards;

import java.util.regex.Pattern;

public abstract class CreditCard {

    private String issuer;
    private String cardNumber;
    private String cardHolder;
    private Pattern expirationDate;
}
