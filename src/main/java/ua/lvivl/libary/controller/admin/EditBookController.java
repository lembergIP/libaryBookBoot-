package ua.lvivl.libary.controller.admin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
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
 * Update book page
 */
@Controller
@RequestMapping(value = "/adm-editBook{bookId}")
public class EditBookController {

    @Autowired
    private BookService bookService;

    private static final Logger logger = LoggerFactory.getLogger(EditBookController.class);

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView editBook(@PathVariable("bookId") long bookId){
        ModelAndView model=new ModelAndView("book/adm-editBook");
        Book book=bookService.findBookById(bookId);
        model.addObject("book",book);
        model.addObject("bookSizeContent",bookService.contentSize(bookId));
        model.addObject("genreList", Genre.values());
        System.out.println("size : " +bookService.contentSize(bookId)+" Mb");
        model.addObject("fileUpload", new FileUploadFormObject());
        return model;
    }
    /**
     * Update book image by @PathVariable book id  and loaded image
     */
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
                bookService.updateBook(book);

            } catch (IOException | JpaSystemException exc) {
              logger.error("Failed to save image", exc);
                return modelAndView;
            }
        }
        return modelAndView;
    }
    /**
     * Update book image by @PathVariable book id  and loaded content(only pdf file)
     */
    @RequestMapping(value = "/updateBookContent{bookId}",method = RequestMethod.POST)
    public ModelAndView updateContentBook(@PathVariable("bookId") long bookId,@RequestParam("file") MultipartFile file) {

        Book book = bookService.findBookById(bookId);
        ModelAndView modelAndView = new ModelAndView("redirect:/adm-editBook"+bookId);
        modelAndView.addObject("book",bookService.findBookById(bookId));
        if (!file.isEmpty()) {
            try {
                byte[] bytes=file.getBytes();

                book.setContent(bytes);
                bookService.updateBook(book);

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
    /**
     * Update book image by @PathVariable book id  and @PathVariable  title book,fio,ganre,publisher,
     * page count and publisher year
     */
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
        book.setGenre(Genre.valueOf(ganre));
        bookService.updateBook(book);
        return modelAndView;
    }
}
