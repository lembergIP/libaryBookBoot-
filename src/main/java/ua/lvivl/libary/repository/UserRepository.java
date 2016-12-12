package ua.lvivl.libary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lvivl.libary.entity.Role;
import ua.lvivl.libary.entity.User;

import java.util.List;

/**
 * Created by lembergIP on 18.10.2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    List<User> findByRole(Role role);
}
