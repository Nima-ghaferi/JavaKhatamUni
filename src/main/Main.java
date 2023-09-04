package main;

import biz.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("What do you want to do: ");
            System.out.println("1. Add customer");
            System.out.println("2. Add Account");
            System.out.println("3.");
            System.out.println("4.");
            System.out.println("5.");
            System.out.println("6.");
            System.out.println("q. Quit");
            System.out.println("-----------------------------");
            String choice = scanner.next();

            if(choice.equalsIgnoreCase("1")){
                CustomerBiz.addCustomer();
            }

            else if(choice.equalsIgnoreCase("2")) {
                AccountBiz.addAccount();
            }

            else if(choice.equalsIgnoreCase("3")) {
                CardBiz.addCard();
            }

            else if(choice.equalsIgnoreCase("q")) {
                break;
            }
            else {
                System.out.println("Command not recognized");
            }
        }
    }
}
