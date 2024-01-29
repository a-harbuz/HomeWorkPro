package de.telran.hw009serializeBook;

import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    /**
     * Создайте объекты класса Book для каждой строки.
     * Используйте Stream API для преобразования строк в объекты.
     * Сериализуйте список книг в файл с использованием ObjectOutputStream.
     */
    public static void main(String[] args) throws RuntimeException {
        //Интересно, сериализовать каждую книгу надо в отдельный файл, или все обьекты в один файл можно ?
        String filePath = "C:\\JAVA\\_190923TT\\src\\main\\java\\org\\example\\_2024_01_25_myChange\\taski\\";
        List<Book> listBooks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath+"taski.txt"));
             ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath+"books.ser"))) {
            reader.lines()
                    //.forEach(System.out::println);
                    .forEach(s->{
                        int id = Integer.parseInt(s.split(", ")[0]);
                        String title = s.split(", ")[1];
                        String author = s.split(", ")[2];
                        int year = Integer.parseInt(s.split(", ")[3]);
                        double price = Double.parseDouble(s.split(", ")[4]);
                        listBooks.add(new Book(id, title,author, year, price));
                    });
            //Book(int id, String title, String author, int year, double price)
            //Save to File
            listBooks.forEach(b->{
                try {
                    outputStream.writeObject(b);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Serialize Object

        // desiarilise Method(Book book)
    }
}

class Main1 {
    /**
     * Десериализуйте список книг из файла,
     * созданного в предыдущем задании, используя ObjectInputStream.
     * Используйте Stream API для фильтрации книг, например, по автору или году издания.
     * Результаты сохраните в новый сериализованный файл
     */
    public static void main(String[] args) {
        String filePath = "C:\\JAVA\\_190923TT\\src\\main\\java\\org\\example\\_2024_01_25_myChange\\taski\\";
        List<Book> listBooks = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath + "books.ser"))) {
            //listBooks.add((Book) inputStream.readObject());
            while (true) {
                try {
                    listBooks.add((Book) inputStream.readObject()); //Deserealization
                } catch (EOFException e) {
                    // Обработка конца файла
                    break;
                }
            }
//            for (int i = 0; i < 5; i++) {
//                listBooks.add((Book) inputStream.readObject());
//            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(listBooks);
        //Save to File
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath + "book1.ser"))) {
            listBooks.stream()
                    .filter(b -> b.getAuthor().startsWith("Дже"))
                    //.forEach(System.out::println);
                    .forEach(b -> {
                        try {
                            outputStream.writeObject(b); //Serealization
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
} // End Main 1

class Main2 {
    /**
     * Отфильтруйте книги с ценой выше определенной суммы. Сериализуйте отфильтрованный список книг в файл.
     */
    public static void main(String[] args) {
        List<Book> bookList = ListBook.getListBook(); //ReadFile
        bookList = bookList.stream()
                .filter(b->b.getPrice()>300)
                .collect(Collectors.toList());

        //System.out.println(bookList);
        ListBook.writeList(bookList, "book2.ser"); //WriteFile
    }
}

class Main3 {
    /**
     Агрегируйте данные, например, подсчитайте среднюю цену книг по каждому автору.
     Сериализуйте результаты в файл.
     */
    public static void main(String[] args) {
        List<Book> bookList = ListBook.getListBook(); //ReadFile
        //System.out.println(bookList);
        Map<String,Double> mapAuthorsAvgPrece =
                bookList.stream()
                        .collect(Collectors.groupingBy(Book::getAuthor, Collectors.averagingDouble(Book::getPrice)));

        //ListBook.writeList(mapAuthorsAvgPrece, "book2.ser"); //WriteFile
        String filePath = "C:\\JAVA\\_190923TT\\src\\main\\java\\org\\example\\_2024_01_25_myChange\\taski\\";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(
                filePath+"mapsAuthor.ser"))) {
            outputStream.writeObject(mapAuthorsAvgPrece); //Serealization
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class Main4 {
    public static void main(String[] args) {
        String filePath = "C:\\JAVA\\_190923TT\\src\\main\\java\\org\\example\\_2024_01_25_myChange\\taski\\";
        try (FileInputStream fis = new FileInputStream(filePath+"taski.txt")) {
            Scanner scanner = new Scanner(fis);
            System.out.println(scanner.useDelimiter("\\A").next().lines());
            //Map<String, Double> authorAveragePrice = scanner.useDelimiter("\\A").next().lines();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
//=======================================================================================================================
class ListBook {
    public static List<Book> getListBook(){
        String filePath = "C:\\JAVA\\_190923TT\\src\\main\\java\\org\\example\\_2024_01_25_myChange\\taski\\";
        List<Book> listBooks = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath+"books.ser"))) {
            //listBooks.add((Book) inputStream.readObject());
            while (true) {
                try {
                    listBooks.add((Book) inputStream.readObject()); //Deserealization
                } catch (EOFException e) {
                    // Обработка конца файла
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listBooks;
    }
    public static void writeList(List<Book> listBooks, String nameFile){
        String filePath = "C:\\JAVA\\_190923TT\\src\\main\\java\\org\\example\\_2024_01_25_myChange\\taski\\";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath+nameFile))) {
            listBooks
                    .forEach(b->{
                        try {
                            outputStream.writeObject(b); //Serealization
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeGanzList(List<Book> listBooks, String nameFile){
        String filePath = "C:\\JAVA\\_190923TT\\src\\main\\java\\org\\example\\_2024_01_25_myChange\\taski\\";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath+nameFile))) {
            outputStream.writeObject(listBooks); //Serealization Ganz List целый
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
