package de.telran.hw002Books;
import lombok.*;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
//@AllArgsConstructor
public class Library {
    private String address;
    private long bookNumbers;
    //private Book[] books;
    private List<Book> books;

    public Library(String address, long bookNumbers, List<Book> books) {
        this.address = address;
        this.bookNumbers = bookNumbers;
        this.books = books;
    }


    public String getAddress() {
        return address;
    }

    public long getBookNumbers() {
        return bookNumbers;
    }

//    public Book[] getBooks() {
//        return List<books>;
//    }
    public List<Book> getBooks() {
        return books;
    }

    public void setBookNumbers(long bookNumbers) {
        this.bookNumbers = bookNumbers;
    }

    @Override
    public String toString() {
        return "Library{" +
                "address='" + address + '\'' +
                ", bookNumbers=" + bookNumbers +
                ", books=" + Arrays.toString(new List[]{books}) +
                '}';
    }

}
