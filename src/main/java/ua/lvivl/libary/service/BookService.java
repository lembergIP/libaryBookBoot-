package ua.lvivl.libary.service;

import ua.lvivl.libary.entity.Book;

import java.util.List;

/**
 * Created by lembergIP on 18.10.2016.
 */
public interface BookService {
    List<Book> findBooksByName(String name);
    List<Book> findBooksByAuthor(String author);
    void createBook(Book book);
    void deleteBook(long id_book);
    void updateBook(Book book);
    Book findBookById(long id_book);
    List<Book> allBooksList();
    List<Book> findBooksByGenre(String genre);
    List<Book> findBooksByLetter(String letter);
    float contentSize(long book_id);

}
