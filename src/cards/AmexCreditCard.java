package cards;

public class AmexCreditCard extends CreditCard{

    public AmexCreditCard(String issuer, String cardNumber, String cardHolder, String expirationDate) throws Exception {
        super(issuer, cardNumber, cardHolder, expirationDate);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
