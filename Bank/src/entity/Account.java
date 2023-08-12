package entity;
import java.math.BigDecimal;
import java.util.*;
import java.math.BigInteger;

public class Account {
    private int accountId;
    private String accountNumber;
    private BigDecimal balance;
    private Date openingDate;
    private List<Integer> customerIdList = new ArrayList<>();
    private BigDecimal minAmount;
    private int ownerId;

    public Account(String accountNumber, Date openingDate, BigDecimal minAmount, int ownerId, int accountId) {
        this.accountNumber = accountNumber;
        this.balance = minAmount;
        this.openingDate = openingDate;
        this.minAmount = minAmount;
        this.ownerId = ownerId;
        this.accountId = accountId;
        customerIdList.add(ownerId);
    }

    public Account() {}

    public int getAccountId() {
        return this.accountId;
    }

    public void setAccountId(int newAccountId) {
        this.accountId = newAccountId;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String newAccountNumber) {
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

    public void setOwnerId(int newOwnerId) {
        this.ownerId = newOwnerId;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public BigDecimal getMinAmount() {
        return this.minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public List<Integer> getCustomerIdList() {
        return this.customerIdList;
    }



}
