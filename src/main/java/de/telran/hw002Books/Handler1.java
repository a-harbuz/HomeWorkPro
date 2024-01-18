package de.telran.hw002Books;

import java.util.*;

public class Handler1 {
    // 1. Вывести все адреса библиотек
    public static void printAllAddresses(List<Library> libraries){
        for (int i = 0; i < libraries.size(); i++) {
            //System.out.println(libraries[i].getAddress());
            System.out.println(libraries.get(i).getAddress());
        }
    }

    // 2. Подсчитать общее количество книг во всех библиотеках
    public static void printTotalBookCount(List<Library> libraries){
        int bookCount = 0;
        for (int i = 0; i < libraries.size(); i++) {
            int count = libraries.get(i).getBooks().size();
            bookCount = bookCount + count;
        }
        System.out.println("Total Num Book= "+ bookCount);
    }

    // 3. Вывести названия всех книг в библиотеке
    public static void printAllBookNames(List<Library> libraries){
        for (int i = 0; i < libraries.size(); i++) {
            //Book[] books = libraries.get(i).getBooks();
            for (int j = 0; j < libraries.get(i).getBooks().size(); j++){
                System.out.println(libraries.get(i).getBooks().get(j).getName());
            }
        }
    }


    //4. Найти библиотеки, где есть электронные книги
    public static void printLibrariesWithEBooks(List<Library> libraries){
            for (int i = 0; i < libraries.size(); i++) {
            for (int j = 0; j < libraries.get(i).getBooks().size(); j++){
                if (libraries.get(i).getBooks().get(j).isEBOOK()) {
                    System.out.println("В библиотеке " + libraries.get(i).getAddress() + "  есть EBOOK!");
                    break;
                }
            }
        }
    }

    //5. Вывести книги в заданном состоянии
    public static void printBooksByCondition(List<Library> libraries, Condition condition){
        for (int i = 0; i < libraries.size(); i++) {
           for (int x = 0; x < libraries.get(i).getBooks().size(); x++){
                if (libraries.get(i).getBooks().get(x).getCondition() == condition) {
                    System.out.println("В библиотеке " + libraries.get(i).getAddress() + "\n" +
                            libraries.get(i).getBooks().get(x).getName() + "   " + condition);
                }
            }
        }
    }

    //6. Вывести список библиотек с количеством книг больше заданного
    public static void printLibrariesWithMoreThanXBooks(List<Library> libraries, long count){
        for (int i = 0; i < libraries.size(); i++) {
            if (libraries.get(i).getBooks().size() > count) {
                System.out.println("В библиотеке " + libraries.get(i).getAddress() + "\nКниг больше " + count);
            }
        }
    }
    //7. Вывести книги, изданные до заданного года
    public static void printBooksIssuedBeforeYear(List<Library> libraries, int year){
        for (int i = 0; i < libraries.size(); i++) {
            for (int j = 0; j < libraries.get(i).getBooks().size(); j++){
                if (libraries.get(i).getBooks().get(j).getIssueYear() < year) {
                    System.out.println(libraries.get(i).getBooks().get(j).getName() + "   " + libraries.get(i).getBooks().get(j).getIssueYear() + " year.");
                }
            }
        }
    }
//************************************************************************************************
    //8. Вывести авторов книг в алфавитном порядке
    public static void printAuthorsAlphabetically(List<Library> libraries){
        List<String> authors = new ArrayList<>();

        for (int i = 0; i < libraries.size(); i++) {
            List <Book> books = libraries.get(i).getBooks();
            for (int j = 0; j < books.size(); j++){
                if (!authors.contains(books.get(j).getAuthor())) {
                    authors.add(books.get(j).getAuthor());
                }
            }
        }

        Collections.sort(authors);
        for(String author : authors){
            System.out.println(author);
        }
    }

    //9. Вывести библиотеки, которые не имеют книг
    public static void printLibrariesWithoutBooks(List<Library> libraries) {
        for (int i = 0; i < libraries.size(); i++) {
            List <Book> books = libraries.get(i).getBooks();
            if (books.size() == 0 ) {
                System.out.println("В библиотеке " + libraries.get(i).getAddress() + " нет книг! ");
            }
        }
    }
    //10. Вывести книги, названия которых начинаются на заданную букву
    public static void printBooksStartingWithLetter(List<Library> libraries, char letter){
        for (int i = 0; i < libraries.size(); i++) {
            List <Book> books = libraries.get(i).getBooks();
            for (int j = 0; j < books.size(); j++){
                if (books.get(j).getName().charAt(0)==letter) {
                    System.out.println(books.get(j).getName());
                }
            }
        }
    }
    //11. Вывести библиотеки по убыванию количества книг // Comparator.comparing
    public static void printLibrariesByDescendingBookCount(List<Library> libraries){
        libraries.sort(Comparator.comparing(Library::getBookNumbers));
        for (int i = libraries.size() - 1; i > 0; i--) {
            System.out.println(libraries.get(i).getAddress());
            System.out.println(libraries.get(i).getBookNumbers());

        }
    }
    // 12. Вывести авторов и количество их книг в каждой библиотеке
    public static void printAuthorsAndTheirBookCounts(List<Library> libraries) {
        for (int i = 0; i < libraries.size(); i++) {
            List <Book> books = libraries.get(i).getBooks();
            List<String> authors = new ArrayList<String>();
            for (int j = 0; j < books.size(); j++){
                if (!authors.contains(books.get(j).getAuthor())) {
                    authors.add(books.get(j).getAuthor());
                }
            }
            Collections.sort(authors);
            System.out.println("Библиотека - " + libraries.get(i).getAddress());

            for(String author : authors){
                int numBook = 0;
                for (int j = 0; j < books.size(); j++){
                    if (books.get(j).getAuthor().equals(author)) {
                        numBook++;
                    }
                }
                System.out.println(author + "  Кол-во книг: " + numBook);
            }

        }
    }


     // 19. Вывести пары "Автор - Самая старая книга" // pair key:value ???
     public static void printAuthorsWithOldestBooks(List<Library> libraries) {
         Map<String,Integer> map = new TreeMap<>();
         for (int i = 0; i < libraries.size(); i++) {
             List<Book> books = libraries.get(i).getBooks();
             for (int j = 0; j < books.size(); j++) {
                 if (!map.containsKey(books.get(j).getAuthor())){
                     map.put(books.get(j).getAuthor(),Integer.MAX_VALUE);
                 }
             }
         }
         //System.out.println(map);

         for (Map.Entry<String,Integer> elem : map.entrySet()) {
             //System.out.println(elem);
             String nameBook = null;
             for (int i = 0; i < libraries.size(); i++) {
                 List<Book> books = libraries.get(i).getBooks();
                 for (int j = 0; j < books.size(); j++) {
                     if (books.get(j).getAuthor().equals(elem.getKey())) {
                         if (books.get(j).getIssueYear() < elem.getValue()){
                             elem.setValue(books.get(j).getIssueYear());
                             nameBook = books.get(j).getName();
                         }
                     }
                 }
             }
             System.out.println(elem.getKey() + " :: " + nameBook + " :: " + elem.getValue());
         }
         //System.out.println(map);
     }
}
