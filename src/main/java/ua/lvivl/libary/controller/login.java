package ua.lvivl.libary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.lvivl.libary.constants.ValidationConstans;
import ua.lvivl.libary.entity.Role;
import ua.lvivl.libary.entity.User;
import ua.lvivl.libary.service.UserService;

/**
 * Created by lembergIP on 24.10.2016.
 */
@Controller
public class login {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/","/login"})
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password!");
        }
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/registration")
    public String saveUser(@RequestParam String mail, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName){

        User user=new User();
        user.setEmail(mail);
            user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userService.createUser(user, Role.USER.name());

        return "redirect:/success";
    }

    @RequestMapping(value = "/success")
    public String success(){
        return "success";
    }

    @RequestMapping("/accessDenied")
    public String handleError403() {
        return  "errors/internal-error";
    }

}
