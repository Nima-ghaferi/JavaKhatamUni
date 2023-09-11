package biz;

import entity.Customer;
import main.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CustomerBiz {
    private static int customerId;

    static {
        customerId = 0;
    }

    public static void addCustomer() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        int customerId = generateCustomerId();
        System.out.println("Customer ID: " + customerId);

        System.out.print("Enter customer first name: ");
        String customerFirstName = scanner.next();

        System.out.print("Enter customer last name: ");
        String customerLastName = scanner.next();

        System.out.print("Enter customer birth date(yyyy/MM//dd): ");
        Date customerBirthDate = new SimpleDateFormat("yyyy/MM//dd").parse(scanner.next());

        System.out.print("Enter customer nationality: ");
        String customerNationality = scanner.next();

        System.out.print("Enter customer national id: ");
        String customerNationalId = scanner.next();

        System.out.print("Enter customer mobile number: ");
        String customerMobileNumber = scanner.next();

        System.out.print("Enter customer address: ");
        String customerAddress = scanner.next();

        System.out.print("Enter customer email: ");
        String customerEmailAddress = scanner.next();

        Data.customers.add(new Customer(customerId, customerFirstName, customerLastName, customerBirthDate,
                customerNationalId, customerMobileNumber, customerAddress, customerEmailAddress, customerNationality));
    }

    public static Customer findById(int customerId) {
        for(Customer customer: Data.customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    public static int generateCustomerId(){
        customerId++;
        return customerId;
    }
}
