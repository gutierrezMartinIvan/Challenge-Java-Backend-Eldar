package cards;

public class NaraCreditCard extends CreditCard{

    public NaraCreditCard(String issuer, String cardNumber, String cardHolder, String expirationDate) throws Exception {
        super(issuer, cardNumber, cardHolder, expirationDate);
    }


    @Override
    public String doOperation() {
        return null;
    }

    @Override
    public boolean isOperationValid() {
        return false;
    }
}
