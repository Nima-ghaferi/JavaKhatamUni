package biz;

import entity.*;
import main.Data;

import java.math.BigInteger;
import java.util.*;
public class AccountBiz {
    private static BigInteger generatedAccountNumber = new BigInteger("999999999999999999");

    public static void addAccount() {
        //Create a scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        //Generate a new account number
        BigInteger accountNumber = generateAccountNumber();

        //Get the minimum amount of credit that must be in the account
        System.out.print("Enter the minimum amount of credit for account: ");
        long minAmount = scanner.nextLong();

        //Enter the opening date
        Date openingDate = new Date();

        //Get owner's ID
        System.out.print("Enter the ID of the owner of the account: ");
        //Add a "while (true)" so the user enters an ID that exists in the system
        int ownerId;
        while (true) {
            ownerId = scanner.nextInt();
            if (Customer.getIdList().contains(ownerId)) {
                break;
            } else {
                System.out.print("This ID is not in the system, please enter the correct ID: ");
                ownerId = scanner.nextInt();
            }
        }

        //Add the information to a new account in the data
        Data.accounts.add(new Account(accountNumber, openingDate, minAmount, ownerId));


    }

    public static BigInteger generateAccountNumber(){
        //For BigInteger class can't use basic mathematical solutions, so we use add method and valueOf method to add 1
        generatedAccountNumber = generatedAccountNumber.add(BigInteger.valueOf(1));
        return generatedAccountNumber;
    }
}
