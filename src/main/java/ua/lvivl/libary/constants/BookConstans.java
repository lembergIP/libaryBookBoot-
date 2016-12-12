package ua.lvivl.libary.constants;

/**
 * Created by lembergIP on 17.10.2016.
 */
public final class BookConstans {

    private BookConstans(){}

    public static final class Entity {

        public static final String TABLE_NAME_BOOK = "books";
        public static final String ID_BOOK = "id_book";
        public static final String NAME_BOOK = "name_book";
        public static final String PAGE_COUNT = "page_count";
        public static final String PUBLISH_YEAR = "publish_year";
        public static final String CONTENT = "content";
        public static final String IMAGE_BOOK = "image_book";
        /*author*/
        public static final String TABLE_NAME_AUTHOR = "author";
        public static final String ID_AUTHOR = "id_author";
        public static final String SURNAME_NAME_AUTHOR = "surname_name_author";
        /*publisher*/
        public static final String TABLE_NAME_PUBLISHER = "publisher";
        public static final String ID_PUBLISHER = "id_publisher";
        public static final String NAME_PUBLISHER = "name_publisher";

        public static final String GENRE = "genre";

        public static final String[] LETTERS = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z" };
        public static final String SEARCH_BY_BOOK = "BOOK";
        public static final String SEARCH_BY_AUTHOR = "AUTHOR";
        private Entity (){}
    }
}
