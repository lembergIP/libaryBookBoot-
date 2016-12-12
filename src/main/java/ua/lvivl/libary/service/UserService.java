package ua.lvivl.libary.service;

import ua.lvivl.libary.entity.Book;
import ua.lvivl.libary.entity.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lembergIP on 18.10.2016.
 */
public interface UserService {
    User findUserByEmail(String email);
    String createUser(User user,String role);
    String deleteUser(String email);
    String updateUser(User user);
    List<User> allUsersList();
    void updatePassword(String email,String password);
}
