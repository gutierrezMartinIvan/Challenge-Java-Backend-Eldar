package cards;

public class AmexCreditCard extends CreditCard{

    private double fee;

    public AmexCreditCard(String issuer, String cardNumber, String cardHolder, String expirationDate) throws Exception {
        super(issuer, cardNumber, cardHolder, expirationDate);
    }

    @Override
    public String feeOperation(Double money) {
        return null;
    }


    @Override
    protected boolean isOperationValid(Double money) {
        return false;
    }

    @Override
    protected void setFee() {

    }
}
