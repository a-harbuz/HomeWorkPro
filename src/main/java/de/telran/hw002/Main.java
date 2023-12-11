package de.telran.hw002;

import java.util.Arrays;
public class Main {
    private static final Library[] libraries = Generator.libraryGen();
    public static void main(String[] args) {
            //System.out.println(Arrays.toString(Generator.bookGenerator(3)));
            Handler.printTotalBookCount(libraries);
            //Handler.printAllAddresses(libraries);
            //Handler.printAllBookNames(libraries[0]);
            //Handler.printLibrariesWithEBooks(libraries);
            //Handler.printBooksByCondition(libraries, Condition.valueOf("DAMAGED"));
            //Handler.printLibrariesWithMoreThanXBooks(libraries, 10);
            //Handler.printBooksIssuedBeforeYear(libraries,2000);
            //Handler.printAuthorsAlphabetically(libraries);
            //Handler.printBooksStartingWithLetter(libraries, 'A');

            Handler.printLibrariesByDescendingBookCount(libraries); //#11
            //Handler.printAuthorsAndTheirBookCounts(libraries); //#12
            //Handler.printMostCommonBookCondition(libraries); //#13
            //Handler.printLibrariesWithoutDamagedBooks(libraries); //#14
            //Handler.printUniqueIssueYears(libraries); //#15
            //Handler.printBooksSortedByIssueYear(libraries); //#16
            //Handler.printCountOfLibrariesWithAtLeastOneEBook(libraries); //#17
            //Handler.printBooksContainingWord(libraries,"Eagle"); //#18
            //Handler.printAuthorsWithOldestBooks(libraries); //#19
            //Handler.printLibrariesWithAllEBooks(libraries); //#20

    }

}
