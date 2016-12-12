package ua.lvivl.libary.controller.admin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.lvivl.libary.constants.BookConstans;
import ua.lvivl.libary.entity.Author;
import ua.lvivl.libary.entity.Book;
import ua.lvivl.libary.entity.Genre;
import ua.lvivl.libary.entity.Publisher;
import ua.lvivl.libary.service.BookService;
import ua.lvivl.libary.util.FileUploadFormObject;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by lembergIP on 09.11.2016.
 */
@Controller
@RequestMapping(value = "/adm-editBook{bookId}")
public class EditBookController {

    @Autowired
    private BookService bookService;

    private static final Logger logger = LoggerFactory.getLogger(EditBookController.class);

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView editBook(@PathVariable("bookId") long bookId){
      //  Long id=Long.parseLong(idBook);
        ModelAndView model=new ModelAndView("book/adm-editBook");
        String[] findBy={BookConstans.Entity.SEARCH_BY_BOOK,BookConstans.Entity.SEARCH_BY_AUTHOR};
        model.addObject("findBy",findBy);
        model.addObject("genreList", Genre.values());
        Book book=bookService.findBookById(bookId);
        model.addObject("book",book);
        model.addObject("bookSizeContent",bookService.contentSize(bookId));
        System.out.println("size : " +bookService.contentSize(bookId)+" Mb");
        model.addObject("fileUpload", new FileUploadFormObject());
        return model;
    }

    @RequestMapping(value = "/updateBookImage{bookId}",method = RequestMethod.POST)
    public ModelAndView updateBookImage(@PathVariable("bookId") long bookId,@RequestParam("file") MultipartFile file) {

        Book book = bookService.findBookById(bookId);
        ModelAndView modelAndView = new ModelAndView("redirect:/adm-editBook"+bookId);
        modelAndView.addObject("book",bookService.findBookById(bookId));
        if (!file.isEmpty()) {
            try {
                byte[] bytes=file.getBytes();
                if(ImageIO.read(new ByteArrayInputStream(bytes)) == null){
                    logger.error("Uploaded image has a wrong extension");
                    return modelAndView;
                }
                book.setImage(bytes);
                bookService.updateBook(bookId,book);

            } catch (IOException | JpaSystemException exc) {
              logger.error("Failed to save image", exc);
                return modelAndView;
            }
        }
        return modelAndView;
    }
    @RequestMapping(value = "/updateBookContent{bookId}",method = RequestMethod.POST)
    public ModelAndView updateContentBook(@PathVariable("bookId") long bookId,@RequestParam("file") MultipartFile file) {

        Book book = bookService.findBookById(bookId);
        ModelAndView modelAndView = new ModelAndView("redirect:/adm-editBook"+bookId);
        modelAndView.addObject("book",bookService.findBookById(bookId));
        if (!file.isEmpty()) {
            try {
                byte[] bytes=file.getBytes();

                book.setContent(bytes);
                bookService.updateBook(bookId,book);

            } catch (IOException | JpaSystemException exc) {
                logger.error("Failed to save image", exc);
                return modelAndView;
            }
        }else{
            logger.error("Empty file" );
            return modelAndView;
        }
        return modelAndView;
    }
    @RequestMapping(value = "/updateBookInfo{bookId}")
    public ModelAndView updateBookInfo(@PathVariable long bookId,@RequestParam String name, @RequestParam String fio,
                                       @RequestParam String ganre, @RequestParam String publisher, @RequestParam int pageCount,
                                       @RequestParam int publishYear){
        ModelAndView modelAndView=new ModelAndView("redirect:/adm-editBook"+bookId);
        Book book=bookService.findBookById(bookId);
        Publisher publisher1=new Publisher();
        Author author=new Author();
        publisher1.setName(publisher);
        author.setFio(fio);

        book.setName(name);
        book.setPageCount(pageCount);
        book.setYearPublish(publishYear);
        book.setPublisher(publisher1);
        book.setAuthor(author);
        for (Genre gen:Genre.values()
             ) {
            if(gen.equals(ganre)){
                book.setGenre(gen);
            }
        }
        bookService.updateBook(bookId,book);
        return modelAndView;
    }
}
