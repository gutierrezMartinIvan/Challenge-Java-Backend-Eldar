package cards;

import utils.VerifyCreditCard;

import java.util.Objects;

public abstract class CreditCard {

    private String issuer;
    private String cardNumber;
    private String cardHolder;
    private String expirationDate;

    public CreditCard(String issuer, String cardNumber, String cardHolder, String expirationDate) throws Exception {
        VerifyCreditCard.validateCreditCardDates(issuer, cardNumber, cardHolder, expirationDate);
        this.issuer = issuer;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
    }
    public String getCreditCardInfo() {
        return  " issuer='" + issuer + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", expirationDate='" + expirationDate;
    }

    public abstract String doOperation();
    public abstract boolean isOperationValid();
    public boolean isCreditCardUsable(){return true;};

    public boolean areEquals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard that)) return false;

        if (!Objects.equals(issuer, that.issuer)) return false;
        if (!Objects.equals(cardNumber, that.cardNumber)) return false;
        if (!Objects.equals(cardHolder, that.cardHolder)) return false;
        return Objects.equals(expirationDate, that.expirationDate);
    }
}
