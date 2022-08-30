package utils;

import exceptions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class VerifyCreditCard {

    public static void validateCreditCardDates(String issuer, String cardNumber, String cardHolder, String expirationDate) throws Exception {
        List<String> existingCreditCards = Arrays.asList("VISA", "NARA", "AMEX");
        verifyIssuer(existingCreditCards, issuer.toUpperCase());
        verifyCardNumber(cardNumber, issuer.toLowerCase());
        verifyCardHolder(cardHolder);
        verifyCardExpirationDate(expirationDate);
    }

    static void verifyCardExpirationDate(String expirationDate) throws ParseException {
        if (!expirationDate.matches("(?:0[1-9]|1[0-2])/[0-9]{2}"))
            throw new InvalidExpirationDateException("Invalid expiration date format. It should look as '01/28'");
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
        simpleDateFormat.setLenient(false);
        Date expiry = simpleDateFormat.parse(expirationDate);
        if (expiry.before(date))
            throw new ExpiredCreditCardException("The credit card is already expired");
    }

    static void verifyCardHolder(String cardHolder) {
        String result = cardHolder.replaceAll("\\s", "");
        IntStream.iterate(0, i -> i + 1).limit(result.length()).forEach(position -> {
            if (!Character.isLetter(result.charAt(position)))
                throw new InvalidCardHolderException("The name only can contain letters");
        });
    }

    static void verifyCardNumber(String cardNumber, String issuer) {
        if (issuer.equals("nara"))
            verifyNaraCreditCardNumber(cardNumber);
        else if (issuer.equals("visa"))
            verifyVisaCreditCardNumber(cardNumber);
        else
            verifyAmexCreditCardNumber(cardNumber);
    }

    static void verifyAmexCreditCardNumber(String cardNumber) {
        String amexRegex = "^3[47][0-9]{13}";
        Pattern pattern = Pattern.compile(amexRegex);
        cardNumber.replace("_", "").replace(" ", "");
        Matcher matcher = pattern.matcher(cardNumber);
        if (!matcher.matches())
            throw new InvalidCreditCardNumberException("Invalid credit card number. Please verify your credit card number");
    }

    static void verifyVisaCreditCardNumber(String cardNumber) {
        String visaRegex = "^4[0-9]{12}(?:[0-9]{3})?$";
        Pattern pattern = Pattern.compile(visaRegex);
        cardNumber.replace("-", "");
        cardNumber.replace(" ", "");
        Matcher matcher = pattern.matcher(cardNumber);
        if (!matcher.matches())
            throw new InvalidCreditCardNumberException("Invalid credit card number. Please verify your credit card number");
    }

    static void verifyNaraCreditCardNumber(String cardNumber) {
        String naraRegex = "^4[0-9]{12}(?:[0-9]{3})?$";
        Pattern pattern = Pattern.compile(naraRegex);
        cardNumber.replace("_", "").replace(" ", "");
        Matcher matcher = pattern.matcher(cardNumber);
        if (!matcher.matches())
            throw new InvalidCreditCardNumberException("Invalid credit card number. Please verify your credit card number");
    }

    static void verifyIssuer(List<String> existingCreditCards, String issuer) throws Exception {
        if (existingCreditCards.contains(issuer)) {
        } else {
            throw new InvalidIssuerException("Invalid issuer credit card. Please verify your credit card issuer.");
        }
    }
}
