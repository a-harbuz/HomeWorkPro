package de.telran.hw002;

import java.util.*;

public class Handler {
    // 1. Вывести все адреса библиотек
    public static void printAllAddresses(Library[] libraries){
        for (int i = 0; i < libraries.length; i++) {
            System.out.println(libraries[i].getAddress());
        }
    }
    // 2. Подсчитать общее количество книг во всех библиотеках
    public static void printTotalBookCount(Library[] libraries){
        int bookCount = 0;
        for (int i = 0; i < libraries.length; i++) {
            int count = libraries[i].getBooks().length;
            bookCount = bookCount + count;
        }
        System.out.println("Total Num Book= "+ bookCount);
    }
    // 3. Вывести названия всех книг в библиотеке
    public static void printAllBookNames(Library library){
        Book[] books = library.getBooks();
        //library
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName());
        }
    }
    // 4. Найти библиотеки, где есть электронные книги
    public static void printLibrariesWithEBooks(Library[] libraries){
        for (int i = 0; i < libraries.length; i++) {
            Book[] books = libraries[i].getBooks();
            for (int x = 0; x < books.length; x++){
                if (books[x].isEBOOK()) {
                    System.out.println("В библиотеке " + libraries[i].getAddress() + "  есть EBOOK!");
                    break;
                }
            }
        }
    }
    //5. Вывести книги в заданном состоянии
    public static void printBooksByCondition(Library[] libraries, Condition condition){
        for (int i = 0; i < libraries.length; i++) {
            Book[] books = libraries[i].getBooks();
            for (int x = 0; x < books.length; x++){
                if (books[x].getCondition() == condition) {
                    System.out.println("В библиотеке " + libraries[i].getAddress() + "\n" +
                            books[x].getName() + "   " + condition);
                }
            }
        }
    }
    //6. Вывести список библиотек с количеством книг больше заданного
    public static void printLibrariesWithMoreThanXBooks(Library[] libraries, long count){
        for (int i = 0; i < libraries.length; i++) {
            Book[] books = libraries[i].getBooks();
            if (books.length > count) {
                System.out.println("В библиотеке " + libraries[i].getAddress() + "\nКниг больше " + count);
            }
        }
    }
    //7. Вывести книги, изданные до заданного года
    public static void printBooksIssuedBeforeYear(Library[] libraries, int year){
        for (int i = 0; i < libraries.length; i++) {
            Book[] books = libraries[i].getBooks();
            for (int x = 0; x < books.length; x++){
                if (books[x].getIssueYear() < year) {
                    System.out.println(books[x].getName() + "   " + books[x].getIssueYear() + " year.");
                }
            }
        }
    }
    //8. Вывести авторов книг в алфавитном порядке
    public static void printAuthorsAlphabetically(Library[] libraries){
        ArrayList<String> authors = new ArrayList<String>();

        for (int i = 0; i < libraries.length; i++) {
            Book[] books = libraries[i].getBooks();
            for (int x = 0; x < books.length; x++){
                //System.out.println(books[x].getAuthor());
                //authors.add(books[x].getAuthor());
                if (!authors.contains(books[x].getAuthor())) {
                    authors.add(books[x].getAuthor());
                }
            }
        }

        Collections.sort(authors);
        for(String author : authors){
            System.out.println(author);
        }
    }

    //9. Вывести библиотеки, которые не имеют книг
    public static void printLibrariesWithoutBooks(Library[] libraries) {
        for (int i = 0; i < libraries.length; i++) {
            Book[] books = libraries[i].getBooks();
            if (books.length == 0 ) {
                System.out.println("В библиотеке " + libraries[i].getAddress() + " нет книг! ");
            }
        }
    }
    //10. Вывести книги, названия которых начинаются на заданную букву
    public static void printBooksStartingWithLetter(Library[] libraries, char letter){
        for (int i = 0; i < libraries.length; i++) {
            Book[] books = libraries[i].getBooks();
            for (int x = 0; x < books.length; x++){
                if (books[x].getName().charAt(0)==letter) {
                    System.out.println(books[x].getName());
                }
            }
        }
    }
    //11. Вывести библиотеки по убыванию количества книг // Comparator.comparing
    public static void printLibrariesByDescendingBookCount(Library[] libraries){
        Arrays.sort(libraries, Comparator.comparing(Library::getBookNumbers));
        for (int i = libraries.length - 1; i > 0; i--) {
            System.out.println(libraries[i].getBookNumbers());
            System.out.println(Arrays.toString(new Library[]{libraries[i]}));
        }
        //System.out.print(libraries[x].getAddress() + " = " + libraries[x].getBookNumbers() + " book\n");
    }
    // 12. Вывести авторов и количество их книг в каждой библиотеке
    public static void printAuthorsAndTheirBookCounts(Library[] libraries) {
        for (int i = 0; i < libraries.length; i++) {
            Book[] books = libraries[i].getBooks();
            ArrayList<String> authors = new ArrayList<String>();
            for (int x = 0; x < books.length; x++){
                if (!authors.contains(books[x].getAuthor())) {
                    authors.add(books[x].getAuthor());
                }
            }
            Collections.sort(authors);
            System.out.println("Библиотека - " + libraries[i].getAddress());

            for(String author : authors){
                int numBook = 0;
                //Book[] books = libraries[i].getBooks();
                for (int x = 0; x < books.length; x++){
                    if (books[x].getAuthor().equals(author)) {
                        numBook++;
                    }
                }
                System.out.println(author + "  Кол-во книг: " + numBook);
            }

        }
    }
    // 13. Вывести наиболее часто встречающееся состояние книг
    public static void printMostCommonBookCondition(Library[] libraries) {
        int nuNew = 0;
        int numOld = 0;
        int numDamaged = 0;

        for (int i = 0; i < libraries.length; i++) {
            Book[] books = libraries[i].getBooks();
            boolean damaged = false;
            for (int x = 0; x < books.length; x++){
                if (books[x].getCondition() == Condition.valueOf("NEW")) nuNew++;
                if (books[x].getCondition() == Condition.valueOf("OLD")) numOld++;
                if (books[x].getCondition() == Condition.valueOf("DAMAGED")) numDamaged++;
            }
        }

        if (nuNew>numOld && nuNew>numDamaged) System.out.println("Больше всего NEW книг: " + nuNew);
        else if (numOld>nuNew && numOld>numDamaged) System.out.println("Больше всего OLD книг: " + numOld);
        else System.out.println("Больше всего DAMAGED книг: " + numDamaged);
    }
    // 14. Вывести библиотеки, где нет поврежденных книг
    public static void printLibrariesWithoutDamagedBooks(Library[] libraries) {
        for (int i = 0; i < libraries.length; i++) {
            Book[] books = libraries[i].getBooks();
            boolean damaged = false;
            for (int x = 0; x < books.length; x++){
                if (books[x].getCondition() == Condition.valueOf("DAMAGED")) {
                    damaged = true;
                    break;
                }
            }
            if (!damaged) System.out.println("В библиотеке " + libraries[i].getAddress() + "нет поврежденных книг!");
        }
    }
    // 15. Вывести все уникальные года издания книг
     public static void printUniqueIssueYears(Library[] libraries) {
         ArrayList<Integer> yearsBooks = new ArrayList<Integer>();

         for (int i = 0; i < libraries.length; i++) {
             Book[] books = libraries[i].getBooks();
             for (int x = 0; x < books.length; x++){
                 //yearsBooks.add(books[x].getIssueYear());
                 if (!yearsBooks.contains(books[x].getIssueYear())) {
                     yearsBooks.add(books[x].getIssueYear());
                 }
             }
         }

         Collections.sort(yearsBooks);
         for(Integer author : yearsBooks){
             System.out.println(author);
         }
     }
     // 16. Вывести книги сортированные по году издания в каждой библиотеке // pair key:value ???
     public static void printBooksSortedByIssueYear(Library[] libraries) {

     }
     // 17. Вывести количество библиотек, где есть хотя бы одна электронная книга
     public static void printCountOfLibrariesWithAtLeastOneEBook(Library[] libraries) {
         int numLib = 0;
         for (int i = 0; i < libraries.length; i++) {
             Book[] books = libraries[i].getBooks();
             for (int x = 0; x < books.length; x++){
                 if (books[x].isEBOOK()) {
                     numLib ++;
                     break;
                 }
             }
         }
         System.out.println("В " + numLib + " библиотеках есть хотябы одна EBOOK!");
     }
     // 18. Вывести книги, чьё название содержит определённое слово
     public static void printBooksContainingWord(Library[] libraries, String word) {
         for (int i = 0; i < libraries.length; i++) {
             Book[] books = libraries[i].getBooks();
             for (int x = 0; x < books.length; x++){
                 if (books[x].getName().contains(word)) {
                     System.out.println(books[x].getName());
                 }
             }
         }

     }
     // 19. Вывести пары "Автор - Самая старая книга" // pair key:value ???
     public static void printAuthorsWithOldestBooks(Library[] libraries) {

     }
     // 20. Вывести библиотеки, в которых каждая книга - электронная
     public static void printLibrariesWithAllEBooks(Library[] libraries) {

         for (int i = 0; i < libraries.length; i++) {
             Book[] books = libraries[i].getBooks();
             boolean noEbookPresent = false;
             for (int x = 0; x < books.length; x++){
                 if (!books[x].isEBOOK()) {
                     noEbookPresent = true;
                     break;
                 }
             }
             if (!noEbookPresent) System.out.println(libraries[i].getAddress() + "\nВсе книги электронные!");
         }
     }


} // END of class Handler
