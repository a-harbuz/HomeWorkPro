package de.telran.hw004;

public class Empl {
    private String name;
    private String surName;
    private Account[] account;
    private Citezenship citizenship;

    public Empl(String name, String surName, Account[] account, Citezenship citizenship) {
        this.name = name;
        this.surName = surName;
        this.account = account;
        this.citizenship = citizenship;
    }

    public Account[] getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public Citezenship getCitizenship() {
        return citizenship;
    }

}
