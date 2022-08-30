package cards;

import exceptions.AmountExceededException;

public class AmexCreditCard extends CreditCard{

    private double fee;

    public AmexCreditCard(String issuer, String cardNumber, String cardHolder, String expirationDate) throws Exception {
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
        //TODO FOR WHAT I'VE LOOKED UP, NARA CREDIT CARDS DON'T HAVE THE DAY OF EXPIRATION, SO I'VE SET THE FEE WITH THE MONTH.
        fee = Double.parseDouble(parts[0]) * 0.5;
    }
}
