package de.telran.hw004;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    Bank bank = new Bank();
    private static final Account[] accounts = Generator.accountsGenerate();

    private static final Empl[] employees = Generator.emplGenerate();
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(accounts));
        //System.out.println(Handler.sumBalances(accounts));
        //System.out.println(Arrays.toString(Handler.findAccountsByCurrency(accounts, Currency.valueOf("USD"))));
        //System.out.println(Handler.hasDebitAccounts(employees[0]));
        System.out.println(Arrays.toString(Handler.getEmployeesByCountry(employees, Country.valueOf("FRANCE"))));
        BigDecimal a = BigDecimal.valueOf(100000);
        System.out.println(Handler.filterAccountsByBalance(accounts, a));

    }
}