package de.telran.hw004Bank;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.util.Random;

import java.math.BigDecimal;
@UtilityClass
public class Generator {
    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();
    public static Account[] accountsGenerate() {
        int num = 20; //Num Of Accounts
        Account[] acc = new Account[num];
        for (int i = 0; i < num; i++) {
            acc[i]= new Account(FAKER.business().creditCardNumber(),
                    getRandomCountry(),
                    getRandomCurrency(),
                    getRandomBalance(),
                    getRandomIsDebit()
            );
        }
        return acc;
    }

    private static Country getRandomCountry() {
        Country[] country = Country.values();
        return country[RANDOM.nextInt(country.length)];
    }

    private static Currency getRandomCurrency() {
        Currency[] currencies = Currency.values();
        return currencies[RANDOM.nextInt(currencies.length)];
    }

    private static BigDecimal getRandomBalance() {
        return new BigDecimal(RANDOM.nextInt(100000000));
    }

    private static boolean getRandomIsDebit() {
        return RANDOM.nextInt() > 0.5;
    }

    private static Citezenship getRandomCitezenship() {
        Citezenship[] citezenship = Citezenship.values();
        return citezenship[RANDOM.nextInt(citezenship.length)];
    }

    public static Empl[] emplGenerate() {
        int num = 30; //Num Of Employee
        Empl[] empl = new Empl[num];
        for (int i = 0; i < num; i++) {
            empl[i]= new Empl(FAKER.name().firstName(),
                    FAKER.name().lastName(),
                    accountsGenerate(),
                    getRandomCitezenship()
            );
        }
        return empl;
    }


}
