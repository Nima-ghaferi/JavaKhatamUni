package biz;

import entity.Customer;
import main.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CustomerBiz {
    private static int generatedCustomerId;

    public static void addCustomer() {
        Scanner scanner = new Scanner(System.in);

        // getting customerId
        int customerId = generateCustomerId();

        // getting customerFirstName
        System.out.print("Enter customer first name: ");
        String customerFirstName = scanner.next();

        // getting customerLastName
        System.out.print("Enter customer last name: ");
        String customerLastName = scanner.next();

        // getting customerBirthDate
        Date customerBirthDate;
        while (true) {
            System.out.print("Enter customer birth date(dd/MM/yyyy): ");
            try {
                customerBirthDate = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.next());
                break;
            } catch (ParseException e) {
                System.out.println("This is invalid birthDate!");
                System.out.println("Enter again!");
            }
        }

        // getting customerNationality
        System.out.print("Enter customer nationality: ");
        String customerNationality = scanner.next();

        // getting customerNationalId
        System.out.print("Enter customer national id: ");
        String customerNationalId = scanner.next();

        // getting customerMobileNumber
        System.out.print("Enter customer mobile number: ");
        String customerMobileNumber = scanner.next();

        // getting customerAddress
        System.out.print("Enter customer address: ");
        String customerAddress = scanner.next();

        // getting customerEmailAddress
        System.out.print("Enter customer email: ");
        String customerEmailAddress = scanner.next();

        Data.customers.add(new Customer(customerId, customerFirstName, customerLastName, customerBirthDate,
                customerNationalId, customerMobileNumber, customerAddress, customerEmailAddress, customerNationality));
    }

    public static int generateCustomerId(){
        generatedCustomerId++;
        return generatedCustomerId;
    }
}
