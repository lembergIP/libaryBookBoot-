package ua.lvivl.libary.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import ua.lvivl.libary.constants.BookConstans;
import ua.lvivl.libary.constants.UserConstants;
import ua.lvivl.libary.constants.ValidationConstans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lembergIP on 17.10.2016.
 */
@Entity
@Table(name = BookConstans.Entity.TABLE_NAME_BOOK)
@Data
public class Book implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = BookConstans.Entity.ID_BOOK)
    private Long id_book;

    @Column(name = BookConstans.Entity.NAME_BOOK)
    @NotNull(message = ValidationConstans.NOT_EMPTY_MESSAGE)
    private String name;

    @Column(name = BookConstans.Entity.CONTENT,columnDefinition = "LONGBLOB")
    @Lob
    private byte[] content;

    @Column(name = BookConstans.Entity.PAGE_COUNT)
    private Integer pageCount;

    @Column(name = BookConstans.Entity.PUBLISH_YEAR)
    private Integer yearPublish;

    @Lob
    @Column(name = BookConstans.Entity.IMAGE_BOOK,columnDefinition = "LONGBLOB")
    private byte[] image;

    @Column(name = BookConstans.Entity.GENRE)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = BookConstans.Entity.ID_AUTHOR)
    private Author author;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = BookConstans.Entity.ID_PUBLISHER)
    private Publisher publisher;


}
