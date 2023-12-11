package de.telran.hw002;
import lombok.*;

import java.util.Arrays;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Library {
    private String address;
    private long bookNumbers;
    private Book[] books;

    public void Library(String address, long bookNumbers, Book[] books) {
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

    public Book[] getBooks() {
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
                ", books=" + Arrays.toString(books) +
                '}';
    }

}
