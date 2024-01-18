package de.telran.hw002Books;
import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.ArrayList;
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
    public static List<Book> bookGenerator (int bookNumbers) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < bookNumbers; i++) {
            books.add(new Book(
                    FAKER.book().author(),
                    FAKER.book().title(),
                    bookIssueDate(),
                    randomConditionGen(),
                    isEbookRandomGen())
            );
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
//    public static Library[] libraryGen() {
//        //UnknownError[] UnknownError;
//        Library[] libraries = new Library[5];
//        //logic.......
//        for (int i = 0; i < libraries.length; i++) {
//            libraries[i] = new Library();
//
//            String address = FAKER.address().fullAddress();
//            //int bookNumbers = 20;
//            int bookNumbers =  RANDOM.nextInt(40 - 20) + 20;
//            Book[] books = bookGenerator(bookNumbers);
//
//            libraries[i].Library(address, bookNumbers, books);
//        }
//        return libraries;
//    }

    public static List<Library> libraryGen() {
        int numLibraries = 20;
        List<Library> libraries = new ArrayList<>();
        //logic.......
        for (int i = 0; i < numLibraries; i++) {
            String address = FAKER.address().fullAddress();
            int bookNumbers =  RANDOM.nextInt(40 - 20) + 20;
            List<Book> books = bookGenerator(bookNumbers);

            libraries.add(new Library(address, bookNumbers, books));
        }
        return libraries;
    }


}
