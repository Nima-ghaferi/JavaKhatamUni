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
import java.util.Scanner;

public class CardBiz {
    private static int generatedCardId = 0;
    private static Random random = new Random();

    public static void addCard() {
        Scanner scanner = new Scanner(System.in);

        int cardId = generateCardId();

        System.out.print("Enter account id: ");
        Account defaultAccount = AccountBiz.findById(scanner.nextInt());

        String cardPAN = generateCardPAN(defaultAccount.getAccountId(), cardId);
        String cardPassword = generateCardPassword();
        LocalDateTime cardCreationDate = LocalDateTime.now();
        LocalDateTime cardExpirationDate = cardCreationDate.plus(5, ChronoUnit.YEARS);
        String CardCvv2 = generateCVV2();
        int customerId = Integer.parseInt(scanner.next());
        Customer cardHolder = CustomerBiz.findById(customerId);

        System.out.println("1. Debit");
        int choice = scanner.nextInt();
        if(choice == 1) {
            CardType cardType = CardType.DEBIT;
        }

        System.out.println("1. Active");
        System.out.println("2. Hot");
        System.out.println("3. Expire");
        choice = scanner.nextInt();
        if(choice == 1){
            CardState cardStatus = CardState.ACTIVE;
        }
        if(choice == 2){
            CardState cardStatus = CardState.HOT;
        }
        if(choice == 3){
            CardState cardStatus = CardState.EXPIRE;
        }

        Card card = new Card(cardId, cardPAN, cardPassword, cardCreationDate, cardExpirationDate, CardCvv2, cardHolder, defaultAccount, cardType, );
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

