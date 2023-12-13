package de.telran.hw004;

import java.math.BigDecimal;
public class Account {
    private String accountNumber;
    private Country country;
    private Currency currency;
    private BigDecimal balance;
    private boolean isDebit;

    public Account(String accountNumber, Country country, Currency currency, BigDecimal balance, boolean isDebit) {
        this.accountNumber = accountNumber;
        this.country = country;
        this.currency = currency;
        this.balance = balance;
        this.isDebit = isDebit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Country getCountry() {
        return country;
    }

    public Currency getCurrency() {
        return currency;
    }

    public boolean getDebit() {
        return isDebit;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setDebit(boolean debit) {
        isDebit = debit;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", country=" + country +
                ", currency=" + currency +
                ", balance=" + balance +
                ", isDebit=" + isDebit +
                "}\n";
    }
}
