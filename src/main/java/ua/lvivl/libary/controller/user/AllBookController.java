package ua.lvivl.libary.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.lvivl.libary.constants.BookConstans;
import ua.lvivl.libary.entity.Genre;
import ua.lvivl.libary.service.BookService;

/**
 * Created by lembergIP on 17.11.2016.
 */
@Controller
@RequestMapping(value = "/allBooks")
public class AllBookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allBooks(){
        ModelAndView modelAndView=new ModelAndView("book/allBooks");
        modelAndView.addObject("allBooks",bookService.allBooksList());
        modelAndView.addObject("genreList", Genre.values());
        String[] findBy={BookConstans.Entity.SEARCH_BY_BOOK,BookConstans.Entity.SEARCH_BY_AUTHOR};
        modelAndView.addObject("findBy",findBy);

        modelAndView.addObject("letter",BookConstans.Entity.LETTERS);
        return modelAndView;
    }
}
