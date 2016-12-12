package ua.lvivl.libary.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.lvivl.libary.entity.Book;
import ua.lvivl.libary.service.BookService;

import java.util.ArrayList;

/**
 * Created by lembergIP on 18.11.2016.
 */
@Controller
@RequestMapping(value = "/findBooksByGenre{genre}")
public class GenreController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findBooksByGenre(@PathVariable("genre") String genre){
        ModelAndView modelAndView=new ModelAndView("book/genrePage");
        ArrayList<Book>books=new ArrayList<Book>();
        books.addAll(bookService.findBooksByGenre(genre));
        modelAndView.addObject("booksByGenre",books);
        System.out.println(genre);
        return modelAndView;
    }

}
