package cards;

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

    @Override
    public String toString() {
        return  " issuer='" + issuer + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", expirationDate='" + expirationDate;
    }
}
