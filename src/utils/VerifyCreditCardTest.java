package utils;

import exceptions.InvalidCardHolderException;
import exceptions.InvalidCreditCardNumberException;
import exceptions.InvalidExpirationDateException;
import exceptions.InvalidIssuerException;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VerifyCreditCardTest {
    @Test()
    void verifyCardExpirationDateThrowsException() {
        assertThrows(InvalidExpirationDateException.class, () -> VerifyCreditCard.verifyCardExpirationDate("asasas"));
    }

    @Test()
    void verifyCardExpirationDateNotThrowsException() {
        assertDoesNotThrow( () -> VerifyCreditCard.verifyCardExpirationDate("12/25"));
    }

    @Test
    void verifyCardHolderThrowsException() {
        assertThrows(InvalidCardHolderException.class, () -> VerifyCreditCard.verifyCardHolder("Martin1 Gutierrez10"));
    }

    @Test
    void verifyCardHolderNotThrowsException() {
        assertDoesNotThrow( () -> VerifyCreditCard.verifyCardHolder("Martin Gutierrez"));
    }

    @Test
    void verifyAmexCreditCardNumberThrowsException() {
        assertThrows(InvalidCreditCardNumberException.class, () -> VerifyCreditCard.verifyAmexCreditCardNumber("3759876"));
    }

    @Test
    void verifyAmexCreditCardNumberNotThrowsException() {
        assertDoesNotThrow( () -> VerifyCreditCard.verifyAmexCreditCardNumber("375987654321001"));
    }

    @Test
    void verifyVisaCreditCardNumberThrowsException() {
        assertThrows(InvalidCreditCardNumberException.class, () -> VerifyCreditCard.verifyVisaCreditCardNumber("453564642342"));
    }

    @Test
    void verifyVisaCreditCardNumberNotThrowsException() {
        assertDoesNotThrow( () -> VerifyCreditCard.verifyVisaCreditCardNumber("4464646464657689"));
    }

    @Test
    void verifyNaraCreditCardNumberThrowsException() {
        assertThrows(InvalidCreditCardNumberException.class, () -> VerifyCreditCard.verifyNaraCreditCardNumber("453564642342"));
    }

    @Test
    void verifyNaraCreditCardNumberNotThrowsException() {
        assertDoesNotThrow( () -> VerifyCreditCard.verifyVisaCreditCardNumber("4575869867932312"));
    }

    @Test
    void verifyIssuerThrowsException() {
        List<String> existingCreditCards = Arrays.asList("VISA", "NARA", "AMEX");
        assertThrows(InvalidIssuerException.class, () -> VerifyCreditCard.verifyIssuer(existingCreditCards, "asasa"));
    }

    @Test
    void verifyIssuerNotThrowsException() {
        List<String> existingCreditCards = Arrays.asList("VISA", "NARA", "AMEX");
        assertThrows(InvalidIssuerException.class, () -> VerifyCreditCard.verifyIssuer(existingCreditCards, "visa"));
    }
}