package biz;

import entity.*;
import main.Data;

import java.math.BigDecimal;
import java.util.*;

public class CardBiz {
    private static int cardId;
    private static List<String> cardPANs;
    private static final Random random;

    static {
        cardId = 0;
        cardPANs = new ArrayList<>();
        random = new Random();
    }

    public static void cardRenewal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the CardPAN: ");
        String cardPAN = scanner.next();
        while (findByPAN(scanner.nextLine()) == null) {
            System.out.print("CardPAN not recognized, renter the CardPAN: ");
            cardPAN = scanner.next();
        }

        System.out.print("Enter password: ");
        String password = scanner.next();
        while(!checkPassword(findByPAN(cardPAN), password)) {
            System.out.print("Wrong password, renter the password: ");
            password = scanner.next();
        }

        Date renewalDate = generateExpiryDate(findByPAN(cardPAN).getExpiryDate());
    }

    public static void addCard() throws Exception {
        Scanner scanner = new Scanner(System.in);

        int cardId = generateCardId();

        String cardPassword = generateCardPassword();

        Date cardCreationDate = new Date();

        Date cardExpiryDate = generateExpiryDate(cardCreationDate);

        String cardCvv2 = generateCVV2();

        System.out.print("Enter card holder ID: ");
        Customer cardHolder = CustomerBiz.findById(scanner.nextInt());
        if(cardHolder == null){
            throw new Exception();
        }

        System.out.print("Enter account ID: ");
        Account cardAccount = AccountBiz.findById(scanner.nextInt());
        if(cardAccount == null){
            throw new Exception();
        }

        String cardPAN = generateCardPAN(Long.parseLong(cardAccount.getAccountNumber()));

        System.out.println("Card Types:");
        System.out.println("1. Debit");
        System.out.println("2. Credit");
        System.out.print("Choose type of card: ");
        String choiceType = scanner.next();
        CardType cardType;
        if(choiceType.equalsIgnoreCase("1")) {
             cardType = CardType.DEBIT;
        }
        else if(choiceType.equalsIgnoreCase("2")){
            cardType = CardType.CREDIT;
        }
        else{
            throw new Exception();
        }

        System.out.println("Card States: ");
        System.out.println("1. Active");
        System.out.println("2. Hot");
        System.out.println("3. Expire");
        System.out.print("Choose state of card: ");
        String choiceState = scanner.next();
        CardState cardStatus;
        if(choiceState.equalsIgnoreCase("1")){
             cardStatus = CardState.ACTIVE;
        }
        else if(choiceState.equalsIgnoreCase("2")){
            cardStatus = CardState.HOT;
        }
        else if(choiceState.equalsIgnoreCase("3")){
            cardStatus = CardState.EXPIRE;
        }
        else{
            throw new Exception();
        }

        Data.cards.add(new Card(cardId, cardPAN, cardPassword, cardCreationDate, cardExpiryDate, cardCvv2, cardHolder,
                                cardAccount, cardType, cardStatus));
    }

    public static BigDecimal getBalance() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter card PAN: ");
        String cardPAN = scanner.next();

        Card card = CardBiz.findByPAN(cardPAN);
        if(card != null) {
            System.out.println("Enter card password: ");
            if(checkPassword(card, scanner.next())){
                return card.getAccount().getBalance();
            }
            else{
                throw new Exception();
            }
        }
        else{
            throw new Exception();
        }
    }

    public static void changeCardState() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter PAN of card: ");
        Card card = findByPAN(scanner.next());
        if(card == null){
            throw new Exception();
        }
        System.out.println("Card States:");
        System.out.println("1. Active");
        System.out.println("2. Hot");
        System.out.println("3. Expire");
        System.out.print("New card state: ");
        String choice = scanner.next();
        if(choice.equalsIgnoreCase("1")){
            card.setState(CardState.ACTIVE);
        }
        else if(choice.equalsIgnoreCase("2")){
            card.setState(CardState.HOT);
        }
        else if(choice.equalsIgnoreCase("3")){
            card.setState(CardState.EXPIRE);
        }
        else{
            throw new Exception();
        }
    }
    private static int generateCardId() {
        cardId++;
        return cardId;
    }

    private static String getRandomCardPAN(long accountNumber) {
        String firstPart = "5022";
        String secondPart = String.format("%04d", random.nextLong(10000));
        String thirdPart = String.valueOf(accountNumber % Math.pow(10,8));
        return String.format("%s%s%s",firstPart, secondPart, thirdPart);
    }

    private static String generateCardPAN(long accountNumber){
        String generatedCardPAN;
        do generatedCardPAN = getRandomCardPAN(accountNumber);
        while (cardPANs.contains(generatedCardPAN));
        cardPANs.add(generatedCardPAN);
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

    private static Date generateExpiryDate(Date createDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createDate);
        calendar.add(Calendar.YEAR, 5);
        return calendar.getTime();
    }

    public static Card findByPAN(String cardPAN) {
        for(Card card: Data.cards) {
            if (card.getPAN().equalsIgnoreCase(cardPAN)) {
                return card;
            }
        }
        return null;
    }

    public static boolean checkPassword(Card card, String password){
        return card.getPassword().equalsIgnoreCase(password);
    }
}

