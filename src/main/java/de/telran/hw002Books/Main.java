package de.telran.hw002Books;

import java.util.*;

public class Main {
   // private static final Library[] libraries = Generator.libraryGen();

    private static final List<Library> libraries = Generator.libraryGen();

    public static void main(String[] args) {
        //System.out.println(Generator.bookGenerator(3));
        //System.out.println(libraries);

        //Handler1.printAllAddresses(libraries);
        //Handler1.printAllBookNames(libraries[0]);
        //Handler1.printLibrariesWithEBooks(libraries);
        //Handler1.printBooksByCondition(libraries, Condition.valueOf("DAMAGED"));
        //Handler1.printLibrariesWithMoreThanXBooks(libraries, 10);
        //Handler1.printBooksIssuedBeforeYear(libraries,2000);
        //Handler1.printAuthorsAlphabetically(libraries); //#
        //Handler1.printBooksStartingWithLetter(libraries, 'A');

        //Handler1.printLibrariesByDescendingBookCount(libraries); //#11
        //Handler1.printAuthorsAndTheirBookCounts(libraries); //#12
        //Handler1.printMostCommonBookCondition(libraries); //#13
        //Handler1.printLibrariesWithoutDamagedBooks(libraries); //#14
        //Handler1.printUniqueIssueYears(libraries); //#15
        //Handler1.printBooksSortedByIssueYear(libraries); //#16
        //Handler1.printCountOfLibrariesWithAtLeastOneEBook(libraries); //#17
        //Handler1.printBooksContainingWord(libraries,"Eagle"); //#18
        //Handler1.printAuthorsWithOldestBooks(libraries); //#19
        //Handler1.printLibrariesWithAllEBooks(libraries); //#20
        Handler1.printAuthorsWithOldestBooks(libraries);

    }

}
