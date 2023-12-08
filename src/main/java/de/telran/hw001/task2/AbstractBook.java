//package de.telran.hw001.task2;
//
////public abstract class AbstractBook {
////    abstract void addToCatalog(Book[] books); //Добавление книги в каталог
////    abstract void removeFromCatalog(Book[] books); //Удаление книги из каталога
////
////}
////
////public abstract class AbstractUser {
////    abstract void borrowBook(Book[] books); // Взятие книги на время.
////    abstract void returnBook(Book[] books); //Возврат книги.
////}
////
////interface ICatalogManagement{
////    default void sortBooksByTitle(Book[] books){
////
////    } // Сортировка книг по названию.
////    default void findBooksByAuthor(Book[] books, String author){
////
////    } //Поиск книг по автору.
////}
////
////interface IUserManagement{
////    default void registerUser(User user){
////
////    } // Регистрация пользователя.
////    default void deleteUser(User user){
////
////    } // Удаление пользователя.
////}
////
////
//////================= Clases =================================
////class FictionBook extends AbstractBook {
////    void calculatePopularity(Book[] books) {
////
////    } //Вычисление популярности.
////
////    void applyDiscount(Book[] books, double discount){
////
////    } // Применение скидки.
////}
////class NonFictionBook extends AbstractBook{
////    void updateInformation(Book[] books, String newInfo){
////
////    } //Обновление информации о книге.
////    void listRelatedBooks(Book[] books, String topic){
////
////    } //Список книг по теме.
////}
////
////class BookCatalog extends ICatalogManagement{
////    void listNewArrivals(Book[] books){
////
////    } //Список новых поступлений.
////
////    void listMostBorrowedBooks(Book[] books){
////
////    } // Список наиболее взятых книг.
////}
////class UserAccounts extends AbstractUser implements IUserManagement {
////    void updateAccount(User user, AccountDetails details){
////
////        } //Обновление учетной записи.
////
////    void trackUserHistory(User user){
////
////        } //Отслеживание истории пользователя.
////}
////class BookReview extends FictionBook {
////    void addReview(Book[] books, Review review){
////
////    } //Добавление отзыва.
////
////    void listReviews(Book[] books){
////
////    } //Список отзывов.
////}
////class ReferenceBook extends NonFictionBook {
////        void listReferences(Book[] books){
////            //Список ссылок.
////        }
////
////        void updateReferences(Book[] books, Reference[] newReferences){
////            //Обновление списка ссылок.
////        }
////}
////class LibraryAnalytics implements ICatalogManagement{
////        void calculateAverageRating(Book[] books){
////        //Вычисление средней оценки книг.
////        }
////
////        void findLeastReadBooks(Book[] books){
////        //Поиск наименее читаемых книг.
////        }
////}
////class Ebook extends FictionBook{
////    void downloadBook(Book[] books){
////        // Скачивание книги.
////    }
////    void updateEbookFormat(Book[] books, String format){
////        // Обновление формата электронной книги.
////    }
////}
////
////class Book{
////    String name;
////    String author;
////    Integer year;
////}
////
////class User{
////    String name;
////    String login;
////    String password;
////}