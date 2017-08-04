package ua.lvivl.libary.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
@SessionAttributes({"user","principal","genreList","findBy","letter"})
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/home","/myacount"},method = RequestMethod.GET)
    public ModelAndView home(Principal principal){
        User user=userService.findUserByEmail(principal.getName());
        ModelAndView modelAndView=new ModelAndView("user/acount");
        modelAndView.addObject("user",user);
        modelAndView.addObject("principal",principal.getName());
        modelAndView.addObject("genreList", Genre.values());
        modelAndView.addObject("letter", BookConstans.Entity.LETTERS);
        String[] findBy={BookConstans.Entity.SEARCH_BY_BOOK,BookConstans.Entity.SEARCH_BY_AUTHOR};
        modelAndView.addObject("findBy",findBy);


        return modelAndView;
    }

}
