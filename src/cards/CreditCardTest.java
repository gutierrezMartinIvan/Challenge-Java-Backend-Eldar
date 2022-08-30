package cards;

import exceptions.AmountExceededException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {
    CreditCard cardAmex;
    CreditCard cardVisa;
    CreditCard cardNara;

    @BeforeEach
    private void start() throws Exception {
        cardAmex = new AmexCreditCard("AMEX", "375987654321001", "GUTIERREZ MARTIN IVAN", "12/25");
        cardVisa = new VisaCreditCard("VISA", "4464646464657689", "MARTIN IVAN", "05/27");
        cardNara = new NaraCreditCard("NARA", "4575869867932312", "IVAN", "09/29");
    }

    @Test
    void feeOperationThrowsException() throws Exception {
        assertThrows(AmountExceededException.class, () -> cardNara.feeOperation(454545D));
        assertThrows(AmountExceededException.class, () -> cardVisa.feeOperation(454545D));
        assertThrows(AmountExceededException.class, () -> cardAmex.feeOperation(454545D));
    }

    @Test
    void feeOperationNotThrowsException() throws Exception {
        assertDoesNotThrow(() -> cardNara.feeOperation(125D));
        assertDoesNotThrow(() -> cardVisa.feeOperation(67D));
        assertDoesNotThrow(() -> cardAmex.feeOperation(98D));
    }

    @Test
    void isOperationValid() {
        assertTrue(cardAmex.isOperationValid(656D));
        assertFalse(cardNara.isOperationValid(45456D));
    }
}