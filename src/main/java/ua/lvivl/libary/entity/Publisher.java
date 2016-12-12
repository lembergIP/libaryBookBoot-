package ua.lvivl.libary.entity;

import lombok.Data;
import ua.lvivl.libary.constants.BookConstans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lembergIP on 17.10.2016.
 */
@Entity
@Table(name = BookConstans.Entity.TABLE_NAME_PUBLISHER)
@Data
public class Publisher{

    @Id
    @GeneratedValue
    @Column(name = BookConstans.Entity.ID_PUBLISHER)
    private Long id_publisher;

    @Column(name = BookConstans.Entity.NAME_PUBLISHER)
    private String name;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<Book> bookList=new ArrayList<>();

}
