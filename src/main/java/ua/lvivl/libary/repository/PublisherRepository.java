package ua.lvivl.libary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lvivl.libary.entity.Publisher;

/**
 * Created by lembergIP on 18.10.2016.
 */
@Repository
@Transactional
public interface PublisherRepository extends JpaRepository<Publisher,Long> {
    Publisher findByName(String name);
}
