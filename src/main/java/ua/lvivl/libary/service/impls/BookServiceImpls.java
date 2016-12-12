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

/**
 * Created by lembergIP on 18.10.2016.
 */
@Service("bookService")
public class BookServiceImpls implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Transactional
    public List<Book> findBooksByName(String name) {
        List<Book>books=new ArrayList<Book>();
        books.addAll(bookRepository.findByName(name));
        return books;
    }

    @Transactional
    public List<Book> findBooksByAuthor(String author) {
        List<Book>books=new ArrayList<Book>() ;
        Author aut=authorRepository.findByFio(author);
        if(aut!=null){
            books.addAll(bookRepository.findByAuthor(aut));
        }

        return books;
    }


    @Transactional
    public void createBook(Book book,String genre) {

        for (Genre gen: Genre.values()
             ) {
            if(gen.name().equals(genre)){
                book.setGenre(gen);
            }
        }
        File imgEmptyBook = new File("src/main/webapp/resources/images/books/emptyImage.png");
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(1000)){
            BufferedImage bufferedImage = ImageIO.read(imgEmptyBook);
            ImageIO.write(bufferedImage, "jpg", baos);
            baos.flush();
        byte[]bytes=baos.toByteArray();
            book.setImage(bytes);
        }
        catch (IOException ioe){

        }
        bookRepository.save(book);

    }

    @Transactional
    public void deleteBook(long id_book) {
            Book book=bookRepository.findOne(id_book);
            bookRepository.delete(book);
        }



    @Transactional
    public void updateBook(long id_book, Book book) {
        Book bookFind=bookRepository.findOne(id_book);
        book.setId_book(id_book);
        bookRepository.saveAndFlush(book);

    }

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
