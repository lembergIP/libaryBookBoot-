package ua.lvivl.libary.controller.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.lvivl.libary.entity.Book;
import ua.lvivl.libary.service.BookService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @PathVariable action (load or read(only pdf format)) book by book id
 */
@Controller
@RequestMapping(value = "/action{action}Book{bookId}")
public class ReadLoadBookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public void loadOrReadBook(@PathVariable("action") String action,@PathVariable("bookId") long bookId, HttpServletResponse response,
                               HttpServletRequest request ) throws IOException {
        System.out.println("book : "+bookId+" ;action : "+action);
        response.setContentType("application/pdf; charset=UTF-8");
        OutputStream out = response.getOutputStream();
        try {
            Book book=bookService.findBookById(bookId);
            byte[]bytes=book.getContent();
            response.setContentLength(bytes.length);
            String filename=book.getName();
            if(action.equals("Load")){
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8") + ".pdf");
            }
            out.write(bytes);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            out.close();
        }

    }
}
