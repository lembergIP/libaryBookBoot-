package ua.lvivl.libary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lvivl.libary.entity.Author;
import ua.lvivl.libary.entity.Book;
import ua.lvivl.libary.entity.Genre;

import java.util.List;

/**
 * Created by lembergIP on 18.10.2016.
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
    List<Book> findByName(String name);
    List<Book> findByAuthor(Author author);
    List<Book> findByGenre(Genre genre);

}
