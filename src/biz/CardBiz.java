package biz;

import entity.*;
import main.Data;

import java.time.LocalDate;
import java.util.*;

public class CardBiz {
    private static int generatedCardId = 0;
    private static List<String> generatedCardPANs = new ArrayList<>();
    private static Random random = new Random();

    public static void addCard() {
        Scanner scanner = new Scanner(System.in);

        int cardId = generateCardId();

        String cardPassword = generateCardPassword();

        Date cardCreationDate = Date.from(LocalDate.now().atStartOfDay()
                .atZone(java.time.ZoneId.systemDefault())
                .toInstant());

        Date cardExpirationDate = getExpirationDate(cardCreationDate);

        String CardCvv2 = generateCVV2();

        System.out.print("Enter card holder for card: ");
        Customer cardHolder = CustomerBiz.findById(scanner.nextInt());

        System.out.print("Enter account id: ");
        Account defaultAccount = AccountBiz.findById(scanner.nextInt());

        assert defaultAccount != null;
        String cardPAN = generateCardPAN(Integer.parseInt(defaultAccount.getAccountNumber()));

        System.out.println("Card Types:");
        System.out.println("1. Debit");
        System.out.print("Choose type of card: ");
        int choice = scanner.nextInt();
        if(choice == 1) {
            CardType cardType = CardType.DEBIT;
        }

        System.out.println("Card States: ");
        System.out.println("1. Active");
        System.out.println("2. Hot");
        System.out.println("3. Expire");
        System.out.print("Choose state of card: ");
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
        String generatedCardPAN = getRandomCardPAN(accountNumber);
        if (generatedCardPANs.contains(generatedCardPAN)) {
            do generatedCardPAN = getRandomCardPAN(accountNumber);
            while (generatedCardPANs.contains(generatedCardPAN));
        }
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

