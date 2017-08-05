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
 * Security(only admin role can add book)
 * Create new book by @RequestParam title Book,fio author ,genre,publisher,page count,publish year
 * and redirect to update page book by id created book
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
        book.setGenre(Genre.valueOf(genre));
        bookService.createBook(book);
        System.out.println("added book : " +book.getId());
        ModelAndView modelAndView=new ModelAndView("redirect:/adm-editBook"+book.getId());
        modelAndView.addObject("bookAddSuccess", ValidationConstans.BOOK_ADDED_SUCCESS);
        return modelAndView;
    }


}
