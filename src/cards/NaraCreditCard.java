package cards;

public class NaraCreditCard extends CreditCard{

    public NaraCreditCard(String issuer, String cardNumber, String cardHolder, String expirationDate) throws Exception {
        super(issuer, cardNumber, cardHolder, expirationDate);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
