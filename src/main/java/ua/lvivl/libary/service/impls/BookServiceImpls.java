package ua.lvivl.libary.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lvivl.libary.entity.Author;
import ua.lvivl.libary.entity.Book;
import ua.lvivl.libary.entity.Genre;
import ua.lvivl.libary.entity.Publisher;
import ua.lvivl.libary.repository.AuthorRepository;
import ua.lvivl.libary.repository.BookRepository;
import ua.lvivl.libary.repository.PublisherRepository;
import ua.lvivl.libary.service.BookService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Service("bookService")
public class BookServiceImpls implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    /**
     * Find all books by title name
     */
    @Transactional
    public List<Book> findBooksByName(String name) {
        List<Book>books=new ArrayList<Book>();
        books.addAll(bookRepository.findByName(name));
        return books;
    }

    /**
     * Find all books by author fio
     */
    @Transactional
    public List<Book> findBooksByAuthor(String author) {
        List<Book>books=new ArrayList<Book>() ;
        Author aut=authorRepository.findByFio(author);
        if(aut!=null){
            books.addAll(bookRepository.findByAuthor(aut));
        }

        return books;
    }

    /**
     * create book
     */
    @Transactional
    public void createBook(Book book) {

        bookRepository.save(book);

    }
    /**
     * delete book by book id
     */
    @Transactional
    public void deleteBook(long id_book) {
            Book book=bookRepository.findOne(id_book);
            bookRepository.delete(book);
        }


    /**
     * update book
     */
    @Transactional
    public void updateBook( Book book) {
        bookRepository.saveAndFlush(book);

    }
    /**
     * Find book by book id
     */
    @Transactional
    public Book findBookById(long id_book) {
        return bookRepository.findOne(id_book);
    }

    @Transactional(readOnly = true)
    public List<Book> allBooksList() {
        List<Book>books=new ArrayList<Book>();
           books.addAll(  bookRepository.findAll());

            return books;

    }
    /**
     * Find all books by genre
     */
    @Transactional(readOnly = true)
    public List<Book> findBooksByGenre(String genre) {
        List<Book>list=new ArrayList<Book>();
        for (Genre gen:Genre.values()
             ) {
            if(gen.toString().equals(genre)){
          list.addAll(bookRepository.findByGenre(gen));
                System.out.println(gen.toString()+" books found : "+list.size());
            }

        }

        return list;
    }
    /**
     * Find all books by book start letter in title
     */
    @Transactional
    public List<Book> findBooksByLetter(String letter) {
        List<Book> bookListLetter = new ArrayList<>();
        List<Book> allBooks = allBooksList();
        char let = letter.charAt(0);
        for (Book book : allBooks) {
            String bookLet = book.getName().toUpperCase();
            if (bookLet.charAt(0) == let) {
                bookListLetter.add(book);
            }
        }
        return bookListLetter;
    }
    /**
     * count book size and convert in MB
     */
    public float contentSize(long book_id){
        float size=0;
        try {
            Book book=findBookById(book_id);
            size=book.getContent().length/1024/1024;
            return size;
        }catch (Exception e){
            return size;
        }

    }
}
