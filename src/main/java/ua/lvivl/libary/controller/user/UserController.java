package ua.lvivl.libary.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lvivl.libary.constants.BookConstans;
import ua.lvivl.libary.entity.Genre;
import ua.lvivl.libary.entity.User;
import ua.lvivl.libary.service.BookService;
import ua.lvivl.libary.service.UserService;

import java.security.Principal;

/**
 * Created by lembergIP on 25.10.2016.
 */
@Controller
@SessionAttributes({"user","principal","genreList","findBy"})
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = {"/home","/myacount"},method = RequestMethod.GET)
    public String home(Principal principal, Model model){
        User user=userService.findUserByEmail(principal.getName());
        model.addAttribute("user",user);
        model.addAttribute("principal",principal.getName());
        model.addAttribute("genreList", Genre.values());
        String[] findBy={BookConstans.Entity.SEARCH_BY_BOOK,BookConstans.Entity.SEARCH_BY_AUTHOR};
        model.addAttribute("findBy",findBy);


        return "user/acount";
    }

}
