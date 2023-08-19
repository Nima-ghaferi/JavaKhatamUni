package biz;

import entity.Card;
import entity.CardType;
import entity.CardState;
import entity.Account;
import entity.Customer;
import main.Data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class CardBiz {
    private static int generatedCardId = 0;
    private static Random random = new Random();

    public static Card issueCard(Account account, Customer cardHolder, CardType cardType) {
        int cardId = generateCardId();

        String cardPAN = generateCardPAN(account.getAccountId(), cardId);
        String cardPassword = generateCardPassword();
        LocalDateTime creationTime = LocalDateTime.now();
        LocalDateTime expirationTime = creationTime.plus(5, ChronoUnit.YEARS);
        String cvv2 = generateCVV2();

        Card card = new Card(cardPAN, cardPassword, creationTime, expirationTime, cvv2, cardHolder, account, cardType, CardState.ACTIVE);
        account.setDefaultCard(card);

        Data.cards.add(card);
        return card;
    }

    private static int generateCardId() {
        return generatedCardId++;
    }

    private static String generateCardPAN(int accountId, int cardId) {
    }

    private static String generateCardPassword() {
        int password = random.nextInt(10000);
        return String.format("%04d", password);
    }

    private static String generateCVV2() {
        int cvv2 = random.nextInt(1000);
        return String.format("%03d", cvv2);
    }
}

