package entity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private int id;
    private String accountNumber;
    private List<Customer> owners = new ArrayList<>();
    private Date openingDate;
    private BigDecimal balance;
    private BigDecimal minAmount;

    public Account(int id, String accountNumber, List<Customer> owners, Date openingDate, BigDecimal minAmount) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.openingDate = openingDate;
        this.balance = minAmount;
        this.minAmount = minAmount;
        this.owners = owners;
    }

    public Account() {

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getMinAmount() {
        return this.minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public List<Customer> getOwners() {
        return owners;
    }

    public void setOwners(List<Customer> owners) {
        this.owners = owners;
    }
}
