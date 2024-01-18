package de.telran.hw004Bank;

import java.math.BigDecimal;
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
        //System.out.println(Arrays.toString(Handler.getEmployeesByCountry(employees, Country.valueOf("FRANCE"))));
        BigDecimal a = BigDecimal.valueOf(83874345);
        System.out.println(Arrays.toString(Handler.filterAccountsByBalance(accounts, a)));

    }
}
