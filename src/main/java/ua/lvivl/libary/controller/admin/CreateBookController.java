package ua.lvivl.libary.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.lvivl.libary.constants.ValidationConstans;
import ua.lvivl.libary.entity.Author;
import ua.lvivl.libary.entity.Book;
import ua.lvivl.libary.entity.Genre;
import ua.lvivl.libary.entity.Publisher;
import ua.lvivl.libary.service.BookService;

/**
 * Created by lembergIP on 28.10.2016.
 */
@Controller
@RequestMapping(value = "/adm-createBook")
public class CreateBookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView bookPage(){
        ModelAndView model=new ModelAndView("book/adm-createBook");
        model.addObject("genreList", Genre.values());
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addBook(@RequestParam String nameBook, @RequestParam String fio,
                          @RequestParam String genre, @RequestParam String publisher, @RequestParam int pageCount,
                          @RequestParam int publishYear){
        Book book=new Book();
        Publisher publisher1=new Publisher();
        Author author=new Author();
        publisher1.setName(publisher);
        author.setFio(fio);

        book.setName(nameBook);
        book.setPageCount(pageCount);
        book.setYearPublish(publishYear);
        book.setPublisher(publisher1);
        book.setAuthor(author);

        bookService.createBook(book,genre);
        System.out.println("added book : " +book.getId_book());
        ModelAndView modelAndView=new ModelAndView("redirect:/adm-editBook"+book.getId_book());
        modelAndView.addObject("bookAddSuccess", ValidationConstans.BOOK_ADDED_SUCCESS);
        return modelAndView;
    }


}
