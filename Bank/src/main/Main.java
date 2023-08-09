package main;

import biz.CustomerBiz;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("What do you want to do: ");
            System.out.println("1. Add customer");
            System.out.println("3.");
            System.out.println("4.");
            System.out.println("5.");
            System.out.println("6.");
            System.out.println("7. Quit");
            System.out.println("-----------------------------");
            String choice = scanner.next();
            if(choice.equalsIgnoreCase("1")){
                CustomerBiz.addCustomer();
                continue;
            };
            if(choice.equalsIgnoreCase("q"))
                break;
        }
    }
}
