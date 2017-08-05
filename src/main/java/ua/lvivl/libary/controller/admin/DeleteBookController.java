package ua.lvivl.libary.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.lvivl.libary.service.BookService;

/**
 * Delete book by @PathVariable book id
 */
@Controller
@RequestMapping(value = "adm-deleteBook{bookId}")
public class DeleteBookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String deleteBook(@PathVariable long bookId){
        System.out.println("delete book : "+bookId);
        bookService.deleteBook(bookId);
        return "redirect:/allBooks";
    }
}
