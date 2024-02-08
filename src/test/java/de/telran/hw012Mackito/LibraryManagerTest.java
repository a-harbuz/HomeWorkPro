package de.telran.hw012Mackito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class LibraryManagerTest {
    private final BookRepository bookRepository = Mockito.mock(BookRepository.class); // Создаем фиктивный объект bookRepository, делаем заглушку
    private final LibraryManager libraryManager = new LibraryManager(bookRepository); //передали заглушку
    private final Book testBook = Mockito.mock(Book.class); //делаем заглушку для Книги
    @Test
    void findBookByIdTest() {
        //пример - для понимания
        LibraryManager libraryManager = new LibraryManager(bookRepository); //передали заглушку
        //libraryManager.findBookById("10"); //вызвали метод
        //Mockito.verify(bookRepository).findById("10"); //проверили, реально ли метод вызвался
        libraryManager.findBookById(Mockito.anyString()); //вызвали метод
        Mockito.verify(bookRepository).findById(Mockito.anyString()); //проверили, реально ли метод вызвался

    }
    @Test
    void findBookByIdClassicTest() {
        //пример - для понимания
        Book testBook = Mockito.mock(Book.class); //делаем заглушку для Книги
        //Book testBook = new Book("1", "Test Book", "Test Author");
        Optional<Book> expected = Optional.of(testBook);

        LibraryManager libraryManager = new LibraryManager(bookRepository); //передали заглушку
        Mockito.when(bookRepository.findById("10")).thenReturn(Optional.of(testBook)); //с имитировали заранее поведение метода интерфейса

        Optional<Book> actual = libraryManager.findBookById("10"); //просим вернуть конкретный рез-т
        Assertions.assertEquals(expected,actual); //проверили что метод будет работать
    }
    @Test
    void findBookByIdClassicAndVerifyTest() {
        //"Тренировочный"
        //Book testBook = null;
        Book testBook = new Book("1", "Test Book", "Test Author");
        Optional<Book> expected = Optional.of(testBook);

        LibraryManager libraryManager = new LibraryManager(bookRepository); //передали заглушку
        ////***Mockito.when(bookRepository.findById("10")).thenReturn(Optional.of(testBook)); //с имитировали заранее поведение метода интерфейса

        Optional<Book> actual = libraryManager.findBookById("10"); //просим вернуть конкретный рез-т, а возвращать нечего, нет реализации
        //можем только протестировать c verify, есть ли обращение к методу или нет!
        //самого интерфейса
        ////***Assertions.assertEquals(expected,actual);

        //libraryManager.findBookById("10");
        Mockito.verify(bookRepository).findById("10");
    }

    @Test
    void findAllBooksTest() {
        libraryManager.findAllBooks(); //вызвали метод
        Mockito.verify(bookRepository).findAll(); //проверили, реально ли метод вызвался

        //проверка, добавляются ли книги в результирующий List<Book>
        Mockito.when(bookRepository.findAll()).thenReturn(List.of(testBook,testBook,testBook));
        Assertions.assertEquals(3, libraryManager.findAllBooks().size());
    }

    @Test
    void addBookTest() {
        Book testBook = new Book("1", "Test Titel", "Test Author");
        libraryManager.addBook(testBook);
        Mockito.verify(bookRepository).save(testBook);
    }
    @Test
    void addBookWithExceptionTest() {
        //Book testBook = new Book("1", null, null);
        Assertions.assertThrows(IllegalArgumentException.class,()->libraryManager.addBook(testBook));
    }

    @Test
    void deleteBookTest() {
        libraryManager.deleteBook(Mockito.anyString()); //вызвали метод
        Mockito.verify(bookRepository).deleteById(Mockito.anyString()); //проверили, реально ли метод вызвался
    }

    @Test
    void updateBookTest() {
        Mockito.when(bookRepository.existsById(Mockito.anyString())).thenReturn(true);

        libraryManager.updateBook(Mockito.anyString(), testBook); //вызвали метод
        Mockito.verify(bookRepository).save(testBook);
    }
    @Test
    void updateBookWithException() {
        Assertions.assertThrows(IllegalArgumentException.class,()->libraryManager.updateBook("10", testBook));
        //Mockito.verify(bookRepository).save(testBook);
    }

    @Test
    void findBooksByAuthor() {
    }

    @Test
    void findBookByTitle() {
    }

    @Test
    void findBooksContainingTitle() {
    }

    @Test
    void lendBook() {
    }

    @Test
    void returnBook() {
    }
}
