package ua.lvivl.libary.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.lvivl.libary.constants.BookConstans;
import ua.lvivl.libary.service.BookService;

/**
 * Finds all the books for a given @PathVariable letter
 */
@Controller
@RequestMapping(value = "/findBooksByLetter{letter}")
public class LetterController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findBooksByLetter(@PathVariable("letter")String letter){
        ModelAndView modelAndView=new ModelAndView("book/findByLetter");
        modelAndView.addObject("letter", BookConstans.Entity.LETTERS);
        modelAndView.addObject("letterBookList",bookService.findBooksByLetter(letter));
        return modelAndView;
    }
}
