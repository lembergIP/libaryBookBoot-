package ua.lvivl.libary.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.lvivl.libary.entity.User;
import ua.lvivl.libary.service.UserService;

/**
 * update user info by @PathVariable user_id and
 * @RequestParam first name,second name and phone number
 *
 */
@Controller
@RequestMapping(value = "/updateUser{userId}")
public class UpdateUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView updateUserInfo(@PathVariable long userId,@RequestParam String name, @RequestParam String secondName, @RequestParam String phone){
        ModelAndView modelAndView=new ModelAndView("redirect:/myacount");
        User user=userService.findUserById(userId);
        user.setFirstName(name);
        user.setLastName(secondName);
        user.setPhone(phone);
        userService.updateUser(user);
        return modelAndView;
    }
}
