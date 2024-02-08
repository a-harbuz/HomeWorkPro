package de.telran.hw012Mackito;
import java.util.List;
import java.util.Optional;

/**
 * Тесты должны покрыть следующие сценарии:
 *
 * Поиск книги по идентификатору.
 * Получение списка всех книг.
 * Добавление книги (с валидацией).
 * Удаление книги по идентификатору.
 * Обновление информации о книге.
 * Поиск книг по автору.
 * Поиск книги по названию.
 * Поиск книг, содержащих в названии заданную строку.
 * Выдача книги на руки (с проверкой состояния).
 * Возврат книги.
 */
public class LibraryManager {
    private final BookRepository bookRepository;

    public LibraryManager(BookRepository bookRepository) { //Constructor
        this.bookRepository = bookRepository;
    }

    public Optional<Book> findBookById(String id) {
        return bookRepository.findById(id);
    }

    //* Получение списка всех книг.
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    // Добавление книги (с валидацией).
    public Book addBook(Book book) {
        if(book.getTitle() == null || book.getAuthor() == null) {
            throw new IllegalArgumentException("Book title and author must not be null");
        }
        return bookRepository.save(book);
    }

    //Удаление книги по идентификатору.
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(String id, Book updatedBook) {
        if(!bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Book with the given id does not exist");
        }
        return bookRepository.save(updatedBook);
    }

    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public Optional<Book> findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> findBooksContainingTitle(String title) {
        return bookRepository.findContainingTitle(title);
    }

    public void lendBook(String bookId, String userId) {
        Optional<Book> book = bookRepository.findById(bookId);
        book.ifPresent(b -> {
            if(b.isLent()) {
                throw new IllegalStateException("Book is already lent");
            }
            b.setLent(true);
            bookRepository.save(b);
        });
    }

    public void returnBook(String bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        book.ifPresent(b -> {
            if(!b.isLent()) {
                throw new IllegalStateException("Book was not lent");
            }
            b.setLent(false);
            bookRepository.save(b);
        });
    }
}

