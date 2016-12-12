package ua.lvivl.libary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lvivl.libary.entity.Author;

/**
 * Created by lembergIP on 18.10.2016.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    Author findByFio(String fio);
}
