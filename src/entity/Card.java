package entity;

import java.util.Date;

public class Card {
    private int id;
    private String PAN;
    private String password;
    private Date creationDate;
    private Date expiryDate;
    private String cvv2;
    private Customer holder;
    private Account account;
    private CardType type;
    private CardState state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public Customer getHolder() {
        return holder;
    }

    public void setHolder(Customer holder) {
        this.holder = holder;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public CardState getState() {
        return state;
    }

    public void setState(CardState state) {
        this.state = state;
    }

    public Card(int id, String PAN, String password, Date creationDate, Date expireDate, String cvv2,
                Customer holder, Account account, CardType type, CardState state) {
        this.id = id;
        this.creationDate = creationDate;
        this.PAN = PAN;
        this.password = password;
        this.expiryDate = expireDate;
        this.cvv2 = cvv2;
        this.holder = holder;
        this.account = account;
        this.type = type;
        this.state = state;
    }
}

