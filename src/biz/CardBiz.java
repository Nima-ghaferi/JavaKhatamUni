package biz;

import entity.*;
import main.Data;

import java.util.*;

public class CardBiz {
    private static int generatedCardId = 0;
    private static List<String> generatedCardPANs = new ArrayList<>();
    private static final Random random = new Random();

    public static void addCard() {
        Scanner scanner = new Scanner(System.in);

        int cardId = generateCardId();

        String cardPassword = generateCardPassword();

        Date cardCreationDate = new Date();

        Date cardExpirationDate = getExpirationDate(cardCreationDate);

        String CardCvv2 = generateCVV2();

        System.out.print("Enter card holder id: ");
        Customer cardHolder = CustomerBiz.findById(scanner.nextInt());

        System.out.print("Enter account id: ");
        Account cardDefaultaccount = AccountBiz.findById(scanner.nextInt());

        String cardPAN = generateCardPAN(Integer.parseInt(cardDefaultaccount.getAccountNumber()));

        System.out.println("Card Types:");
        System.out.println("1. Debit");
        System.out.print("Choose type of card: ");
        int choice = scanner.nextInt();
        CardType cardType = null;
        if(choice == 1) {
             cardType = CardType.DEBIT;
        }
        else{
            System.out.println("invalid input!");
        }

        System.out.println("Card States: ");
        System.out.println("1. Active");
        System.out.println("2. Hot");
        System.out.println("3. Expire");
        System.out.print("Choose state of card: ");
        choice = scanner.nextInt();
        CardState cardStatus = null;
        if(choice == 1){
             cardStatus = CardState.ACTIVE;
        }
        else if(choice == 2){
            cardStatus = CardState.HOT;
        }
        else if(choice == 3){
            cardStatus = CardState.EXPIRE;
        }
        else{
            System.out.println("invalid input!");
        }

        Data.cards.add(new Card(cardId, cardPAN, cardPassword, cardCreationDate, cardExpirationDate, CardCvv2, cardHolder, cardDefaultaccount, cardType, cardStatus));

    }

    private static int generateCardId() {
        generatedCardId++;
        return generatedCardId;
    }

    private static String getRandomCardPAN(int accountNumber) {
        String firstPart = "5022";
        String secondPart = String.valueOf(random.nextLong(1000,10000));
        String thirdPart = String.valueOf(accountNumber % Math.pow(10,8));
        return String.format("%s%s%s",firstPart, secondPart, thirdPart);
    }

    private static String generateCardPAN(int accountNumber){
        String generatedCardPAN;
        do generatedCardPAN = getRandomCardPAN(accountNumber);
        while (generatedCardPANs.contains(generatedCardPAN));
        generatedCardPANs.add(generatedCardPAN);
        return generatedCardPAN;
    }

    private static String generateCardPassword() {
        int password = random.nextInt(10000);
        return String.format("%04d", password);
    }

    private static String generateCVV2() {
        int cvv2 = random.nextInt(1000);
        return String.format("%03d", cvv2);
    }

    private static Date getExpirationDate(Date createDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createDate);
        calendar.add(Calendar.YEAR, 5);
        return calendar.getTime();
    }
}

