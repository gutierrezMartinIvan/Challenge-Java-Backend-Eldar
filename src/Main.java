import cards.AmexCreditCard;
import cards.CreditCard;
import cards.NaraCreditCard;
import cards.VisaCreditCard;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<CreditCard> cards = new ArrayList<>();
        cards.add(new AmexCreditCard("AMEX", "375987654321001", "GUTIERREZ MARTIN IVAN", "12/25"));
        cards.add(new VisaCreditCard("VISA", "4464646464657689", "MARTIN IVAN", "05/27"));
        cards.add(new NaraCreditCard("NARA", "4575869867932312", "IVAN", "09/29"));
        cards.add(new NaraCreditCard("NARA", "4575869867932312", "IVAN", "09/29"));
        cards.forEach(card -> {
            System.out.println(card.getCreditCardInfo());
            System.out.println(card.isCreditCardUsable());
        });

        System.out.println(cards.get(0).feeOperation(999D));
        System.out.println(cards.get(1).feeOperation(999D));
        System.out.println(cards.get(2).feeOperation(999D));

        System.out.println(cards.get(1).areEquals(cards.get(2)));
        System.out.println(cards.get(2).areEquals(cards.get(3)));

    }
}