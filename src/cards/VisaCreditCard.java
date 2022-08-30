package cards;

public class VisaCreditCard extends CreditCard{

    public VisaCreditCard(String issuer, String cardNumber, String cardHolder, String expirationDate) throws Exception {
        super(issuer, cardNumber, cardHolder, expirationDate);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
