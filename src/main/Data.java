package main;

import entity.Account;
import entity.Card;
import entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Customer> customers;
    public static List<Account> accounts;
    public static List<Card> cards;

    static{
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
        cards = new ArrayList<>();
    }
}
