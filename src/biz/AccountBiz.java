package biz;

import entity.*;
import main.Data;

import java.math.BigDecimal;
import java.util.*;
public class AccountBiz {
    private static int accountId;

    public static void addAccount() throws Exception {
        Scanner scanner = new Scanner(System.in);

        int accountId = generateAccountId();
        System.out.println("Account ID: " + accountId);

        Date accountOpeningDate = new Date();
        System.out.println("Opening Date of account: " + accountOpeningDate);

        System.out.println("Choose type of account: ");
        System.out.println("1. Individual");
        System.out.println("2. Joint");
        String choice = scanner.next();
        AccountType accountType;
        if(choice.equalsIgnoreCase("1")){
            accountType = AccountType.INDIVIDUAL;
        }
        else if(choice.equalsIgnoreCase("2")){
            accountType = AccountType.JOINT;
        }
        else{
            throw new Exception();
        }


        List<Customer> accountOwners = new ArrayList<>();
        if(accountType == AccountType.INDIVIDUAL){
            System.out.print("Enter ID of owner of account: ");
            int accountOwnerID = scanner.nextInt();
            if(validateId(accountOwnerID)){
                accountOwners.add(CustomerBiz.findById(accountOwnerID));
            }
            else{
                throw new Exception();
            }
        }
        else if(accountType == AccountType.JOINT){
            System.out.print("Enter ID of owners for account(split by comma): ");
            String[] accountOwnerIDs = scanner.next().split(",");
            for(String id : accountOwnerIDs){
                if(validateId(Integer.parseInt(id.trim()))){
                    accountOwners.add(CustomerBiz.findById(Integer.parseInt(id.trim())));
                }
                else{
                    throw new Exception();
                }
            }
        }

        System.out.print("Enter the minimum balance of credit for account: ");
        BigDecimal minAmount = scanner.nextBigDecimal();

        String accountNumber = generateAccountNumber(accountOwners, accountId);

        Data.accounts.add(new Account(accountId, accountNumber, accountType, accountOwners, accountOpeningDate, minAmount));
    }

    public static int generateAccountId(){
        accountId++;
        return accountId;
    }

    public static String generateAccountNumber(List<Customer> owners, int accountId) {
        StringBuilder firstPart = new StringBuilder();
        for(Customer owner : owners){
            firstPart.append(String.format("%02d", owner.getId() % 100));
        }
        String secondPart = String.format("%02d", accountId % 100);
        int digit = 16 - (owners.size() + 1) * 2;
        long leftLimit = (long) Math.pow(10, digit);
        long rightLimit = (long) Math.pow(10, digit + 1);
        long generatedLong = leftLimit + (long)(Math.random() * (rightLimit - leftLimit));
        String thirdPart = String.valueOf(generatedLong);
        return firstPart + secondPart + thirdPart;
    }

    public static boolean validateId(int ownerId) {
        for(Customer customer: Data.customers) {
            if(customer.getId() == ownerId) {
                return true;
            }
        }
        return false;
    }

    public static Account findById(int accountId) {
        for(Account account: Data.accounts) {
            if (account.getId() == accountId) {
                return account;
            }
        }
        return null;
    }
}
