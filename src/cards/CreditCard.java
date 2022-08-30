package cards;

import utils.VerifyCreditCard;

import java.util.Objects;

public abstract class CreditCard {

    private final String issuer;
    private final String cardNumber;
    private final String cardHolder;

    private final String expirationDate;

    public CreditCard(String issuer, String cardNumber, String cardHolder, String expirationDate) throws Exception {
        VerifyCreditCard.validateCreditCardDates(issuer, cardNumber, cardHolder, expirationDate);
        this.issuer = issuer;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
        setFee();
    }

    public String getCreditCardInfo() {
        return "Issuer='" + issuer + '\'' +
                ", Card number='" + cardNumber + '\'' +
                ", Card holder='" + cardHolder + '\'' +
                ", Expiration date='" + expirationDate + "'";
    }

    public abstract String feeOperation(Double money);

    protected boolean isOperationValid(Double money) {
        return money < 1000D && money > 0;
    }

    public boolean isCreditCardUsable() {
        return true;
    }

    protected abstract void setFee();

    public boolean areEquals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard that)) return false;

        if (!Objects.equals(issuer, that.issuer)) return false;
        if (!Objects.equals(cardNumber, that.cardNumber)) return false;
        if (!Objects.equals(cardHolder, that.cardHolder)) return false;
        return Objects.equals(expirationDate, that.expirationDate);
    }

    protected String getExpirationDate() {
        return expirationDate;
    }
}
