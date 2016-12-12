package ua.lvivl.libary.dto;

import lombok.Data;
import ua.lvivl.libary.entity.Genre;

/**
 * Created by lembergIP on 11.11.2016.
 */
@Data
public class BookDTO {
    private String name;
    private String genre;
    private Integer pageCount;
    private String fio;
    private String publisherName;
}
