package ua.lvivl.libary.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lvivl.libary.entity.Book;
import ua.lvivl.libary.entity.Role;
import ua.lvivl.libary.entity.User;
import ua.lvivl.libary.repository.BookRepository;
import ua.lvivl.libary.repository.UserRepository;
import ua.lvivl.libary.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service("userService")
public class UserServiceImpls implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);


    }
    /**
     * Create user and auto role user
     */
@Transactional
    public String createUser(User user, String role) {
        User findUser = findUserByEmail(user.getEmail());
        try {
            if (findUser == null) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                for (Role roles :
                        Role.values()) {
                    if (roles.name().equals(role)) {
                        user.setRole(roles);
                    }

                }
                userRepository.save(user);
                return "success";
            }
        } catch (Exception e) {
            return "failed : " + e;
        }
        return "failed";
    }
    /**
     * delete user by email
     */
    @Transactional
    public String deleteUser(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            userRepository.delete(user);
            return "success";
        } else {
            return "user not found";
        }
    }
    /**
     * update user info
     */
    @Transactional
    public String updateUser(User user) {
        User userFind = userRepository.findByEmail(user.getEmail());
        if (userFind != null) {
            userRepository.saveAndFlush(userFind);
            return "success";
        } else {
            return "user not found";
        }


    }
    /**
     * Find user by user id
     */
    @Transactional
    public User findUserById(long id){
        User user=userRepository.findOne(id);
        if(user!=null){
            return user;
        }
        return new User();
    }
    /**
     * Load all users list
     */
    @Transactional(readOnly = true)
    public List<User> allUsersList() {
        List<User>list=userRepository.findAll();
        if(list!=null){
            return list;
        }else {
        return new ArrayList<User>();}
    }


}
