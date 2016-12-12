package ua.lvivl.libary.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lvivl.libary.constants.UserConstants;
import ua.lvivl.libary.entity.User;
import ua.lvivl.libary.service.UserService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lembergIP on 18.10.2016.
 */
@Service(UserConstants.Model.USER_DETAILS_SERVICE)
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("not found");
        }

        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(user.getRole().getAuthority()));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                roles);
    }
}
