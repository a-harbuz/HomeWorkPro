package de.telran.hw002;
import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class Generator {
    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();

    private static Condition randomConditionGen() {
        Condition[] conditions = Condition.values(); //new old damaged
        int index = RANDOM.nextInt(3);
        return conditions[index];
    }

    private static boolean isEbookRandomGen() {
        boolean[] isEbook = {true, false};
        int index = RANDOM.nextInt(2);
        return isEbook[index];
    }
    // ==== bookGenerator ===
    public static Book[] bookGenerator(int bookNumbers) {
        Book[] books = new Book[bookNumbers];
        for (int i = 0; i < bookNumbers; i++) {
            books[i] = new Book(FAKER.book().author(),
                    FAKER.book().title(),
                    bookIssueDate(),
                    randomConditionGen(),
                    isEbookRandomGen());
        }
        return books;
    }

    //todo
    private static int bookIssueDate() {
        /**
         * gen 1900 - 2022
         */
        return RANDOM.nextInt(2022 - 1900) + 1900;
    }

    // ==== libraryGen ===
    public static Library[] libraryGen() {
        //UnknownError[] UnknownError;
        Library[] libraries = new Library[5];
        //logic.......
        for (int i = 0; i < libraries.length; i++) {
            libraries[i] = new Library();

            String address = FAKER.address().fullAddress();
            //int bookNumbers = 20;
            int bookNumbers =  RANDOM.nextInt(40 - 20) + 20;
            Book[] books = bookGenerator(bookNumbers);

            libraries[i].Library(address, bookNumbers, books);
        }
        return libraries;
    }
}
