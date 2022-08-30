package cards;

import exceptions.AmountExceededException;

public class NaraCreditCard extends CreditCard{

    private double fee;
    public NaraCreditCard(String issuer, String cardNumber, String cardHolder, String expirationDate) throws Exception {
        super(issuer, cardNumber, cardHolder, expirationDate);
    }

    @Override
    public String feeOperation(Double money) {
        if(isOperationValid(money))
            return "The fee for the operation is: $" + String.format("%.2f",fee*money);
        else
            throw new AmountExceededException("The operation can only be carried out with a value of up to $999.99");
    }

    @Override
    protected void setFee() {
        String result = super.getExpirationDate().replaceAll("/", "");
        final int mid = result.length() / 2;
        String[] parts = {result.substring(0, mid), result.substring(mid)};
        fee = Double.parseDouble(parts[0]) * 0.1;
    }
}
