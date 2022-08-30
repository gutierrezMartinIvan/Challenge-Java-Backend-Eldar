package cards;

public class NaraCreditCard extends CreditCard{

    private double fee;
    public NaraCreditCard(String issuer, String cardNumber, String cardHolder, String expirationDate) throws Exception {
        super(issuer, cardNumber, cardHolder, expirationDate);
    }

    @Override
    public String feeOperation(Double money) {
        return null;
    }

    @Override
    protected void setFee() {

    }
}
