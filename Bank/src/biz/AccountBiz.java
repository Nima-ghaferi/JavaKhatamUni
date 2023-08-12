package biz;

import entity.*;
import main.Data;

import java.math.BigDecimal;
import java.util.*;
public class AccountBiz {
    private static int generatedAccountId;

    public static void addAccount() throws Exception {
        Scanner scanner = new Scanner(System.in);

        int accountId = generateAccountId();

        System.out.print("Enter the minimum balance of credit for account: ");
        BigDecimal minAmount = scanner.nextBigDecimal();

        Date openingDate = new Date();

        System.out.print("Enter the ID of the owner of the account: ");
        int ownerId = scanner.nextInt();
        while(true) {
            try {
                if(validateId(ownerId)) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch(Exception e) {
                System.out.print("Invalid ID, enter a valid ID: ");
                ownerId = scanner.nextInt();
            }
        }

        String accountNumber = generateAccountNumber(ownerId, accountId);

        Data.accounts.add(new Account(accountNumber, openingDate, minAmount, ownerId, accountId));


    }

    public static int generateAccountId(){
        generatedAccountId++;
        return generatedAccountId;
    }

    public static String generateAccountNumber(int ownerId, int accountId) throws Exception {
        Customer customer = CustomerBiz.findCustomerById(ownerId);
        if(customer == null) {
            throw new Exception("Customer ID not found");
        }
        String firstPart = String.valueOf(ownerId % 10);
        String secondPart = customer.getNationalId().substring(0, 6);
        String thirdPart = String.valueOf(accountId % 10);
        long leftLimit = 10000000L;
        long rightLimit = 100000000L;
        long generatedLong = leftLimit + (long)(Math.random() * (rightLimit - leftLimit));
        String lastPart = String.valueOf(generatedLong);
        return firstPart + secondPart + thirdPart + lastPart;
    }

    public static boolean validateId(int ownerId) {
        for(Customer customer: Data.customers) {
            if(customer.getId() == ownerId) {
                return true;
            }
        }
        return false;
    }

    public static Account findAccountById(int accountId) {
        for(Account account: Data.accounts) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }
        return null;
    }
}
