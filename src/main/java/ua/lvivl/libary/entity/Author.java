package ua.lvivl.libary.entity;

import lombok.Data;

import ua.lvivl.libary.constants.BookConstans;
import ua.lvivl.libary.constants.UserConstants;

import javax.persistence.*;
import java.io.Serializable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lembergIP on 17.10.2016.
 */
@Entity
@Table(name = BookConstans.Entity.TABLE_NAME_AUTHOR)
@Data
public class Author{

    @Id
    @GeneratedValue
    @Column(name=BookConstans.Entity.ID_AUTHOR)
    private Long id_author;

    @Column(name = BookConstans.Entity.SURNAME_NAME_AUTHOR)
    private String fio;


    @Column(name = UserConstants.Entity.DATE_OF_BIRTH)
    private Date dateOfBirth;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> authorList=new ArrayList<Book>();

}
