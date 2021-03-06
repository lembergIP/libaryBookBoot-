package ua.lvivl.libary.controller.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.lvivl.libary.entity.Book;
import ua.lvivl.libary.service.BookService;
import ua.lvivl.libary.util.ImagesHolderUtil;


@Controller
public class ImageController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/imageBook/{idBook}", produces = MediaType.IMAGE_JPEG_VALUE, method = RequestMethod.GET)
    @ResponseBody public byte[] getProfilePic(@PathVariable long idBook)
            throws
            AccessDeniedException {
        Book book=bookService.findBookById(idBook);
        if(book.getImage()==null){
            return ImagesHolderUtil.getDefaultPictureBook();
        }

        return book.getImage();
    }
}
