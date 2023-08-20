package entity;

import java.util.Date;

public class Card {
    private int cardId;
    private String cardPAN;
    private String password;
    private Date createDate;
    private Date expireDate;
    private String cvv2;
    private Customer cardHolder;
    private Account defaultAccount;
    private CardType cardType;
    private CardState state;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardPAN() {
        return cardPAN;
    }

    public void setCardPAN(String cardPAN) {
        this.cardPAN = cardPAN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public Customer getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(Customer cardHolder) {
        this.cardHolder = cardHolder;
    }

    public Account getDefaultAccount() {
        return defaultAccount;
    }

    public void setDefaultAccount(Account defaultAccount) {
        this.defaultAccount = defaultAccount;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardState getState() {
        return state;
    }

    public void setState(CardState state) {
        this.state = state;
    }

    public Card(int cardId, String cardPAN, String password, Date expireDate, String cvv2, Customer cardHolder, Account defaultAccount, CardType cardType, CardState state) {
        this.cardPAN = cardPAN;
        this.password = password;
        this.expireDate = expireDate;
        this.cvv2 = cvv2;
        this.cardHolder = cardHolder;
        this.defaultAccount = defaultAccount;
        this.cardType = cardType;
        this.state = state;
    }
}

