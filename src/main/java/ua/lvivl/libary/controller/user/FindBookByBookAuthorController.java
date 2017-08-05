package ua.lvivl.libary.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.lvivl.libary.constants.BookConstans;
import ua.lvivl.libary.constants.ValidationConstans;
import ua.lvivl.libary.entity.Genre;
import ua.lvivl.libary.service.BookService;

/**
 * Search all books by @RequestParam title or author fio
 */
@Controller
@RequestMapping(value = "/bookFindBy")
public class FindBookByBookAuthorController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findBookBy( @RequestParam String searchCriteria,@RequestParam String searchBy){
        ModelAndView modelAndView=new ModelAndView("book/findBooksBy");
        modelAndView.addObject("genreList", Genre.values());
        String[] findBy={BookConstans.Entity.SEARCH_BY_BOOK,BookConstans.Entity.SEARCH_BY_AUTHOR};
        modelAndView.addObject("findBy",findBy);
        modelAndView.addObject("letter",BookConstans.Entity.LETTERS);
        if(searchBy.equalsIgnoreCase(BookConstans.Entity.SEARCH_BY_BOOK)){
            modelAndView.addObject("listFindBy",bookService.findBooksByName(searchCriteria));
            return modelAndView;
        }
        modelAndView.addObject("listFindBy",bookService.findBooksByAuthor(searchCriteria));
        return modelAndView;
    }

}
