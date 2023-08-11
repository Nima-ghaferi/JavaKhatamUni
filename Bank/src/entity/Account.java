package entity;
import java.util.*;
import java.math.BigInteger;

public class Account {
    //Fields for Account class
    private BigInteger accountNumber;
    private long balance;
    private Date openingDate;
    //Customer ID list is a list of customers who have withdrawal rights to the account
    private List<Integer> customerIdList = new ArrayList<>();
    private long minAmount;
    private int ownerId;

    //Constructor to get some needed values and to create a new variable from class Account
    public Account(BigInteger accountNumber, Date openingDate, long minAmount, int ownerId) {
        this.accountNumber = accountNumber;
        this.balance = minAmount;
        this.openingDate = openingDate;
        this.minAmount = minAmount;
        this.ownerId = ownerId;
        customerIdList.add(ownerId);
    }

    //Empty constructor
    public Account() {}

    //setters and getters
    public BigInteger getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(BigInteger newAccountNumber) {
        this.accountNumber = newAccountNumber;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date newOpeningDate) {
        this.openingDate = newOpeningDate;
    }

    public int getOwnerId() {
        return this.ownerId;
    }

    public void setOwner(int newOwnerId) {
        this.ownerId = newOwnerId;
    }

    public long getBalance() {
        return this.balance;
    }

    //Withdraw method to take credit out of the account
    public void withdraw(int customerId, long withdrawalAmount) throws Exception {
        //Customer must have to authority to withdraw money
        if(customerIdList.contains(customerId)) {
            //Withdrawal amount should not cause problems
            if(this.balance - withdrawalAmount >= this.minAmount) {
                this.balance -= withdrawalAmount;
            } else {
                throw new Exception("Withdrawal amount is too high");
            }
        } else {
            throw new Exception("This customer does not have the authority to withdraw any amount of credit");
        }
    }

    //Deposit method to add credit to the account
    public void deposit(long depositAmount) {
        this.balance += depositAmount;
    }

    public long getMinAmount() {
        return this.minAmount;
    }

    public void setMinAmount(long minAmount) {
        this.minAmount = minAmount;
    }

    public List<Integer> getCustomerIdList() {
        return this.customerIdList;
    }

    //Add new customers to the list of customers with withdrawal rights
    public void giveWithdrawalRights(int customerId) throws Exception {
        //Check if the customer requested to be given withdrawal rights isn't repetitive
        if(this.customerIdList.contains(customerId)) {
            throw new Exception("This customer already have withdrawal rights");
        } else {
            this.customerIdList.add(customerId);
        }
    }

    //Revoke a customers withdrawal rights
    public void revokeWithdrawalRights(int customerId) throws Exception {
        //Check if the customer requested for their withdrawal rights to be taken away are in the list
        if(this.customerIdList.contains(customerId)) {
            this.customerIdList.remove(customerId);
        } else {
            throw new Exception("This customer does not have withdrawal rights");
        }
    }


}
