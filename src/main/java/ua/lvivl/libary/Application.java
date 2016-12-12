package ua.lvivl.libary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import ua.lvivl.libary.entity.*;
import ua.lvivl.libary.service.BookService;
import ua.lvivl.libary.service.UserService;

import javax.annotation.PostConstruct;
import java.sql.Date;


@SpringBootApplication
public class Application extends SpringBootServletInitializer {



	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	/*@PostConstruct
		public void init(){
		System.out.println("- - - - - - - - -- - start");
		User user=new User();
		user.setEmail("test@mail.com");
		user.setPassword("123456");
		user.setFirstName("Pavlo");
		user.setLastName("Ivanov");
		user.setPhone("0934234564");
		String u=userService.createUser(user,Role.ADMINISTRATOR.name());
		System.out.println("result : "+u);
		System.out.println("user created !!!!");
		Book book=new Book();
		Publisher publisher=new Publisher();
		Author author=new Author();
		publisher.setName("Chaika");
		author.setFio("Taras Shevchenko");


		book.setName("Kobzar");
		book.setPublisher(publisher);
		book.setAuthor(author);
		book.setPageCount(658);
		book.setYearPublish(1840);
		bookService.createBook(book,Genre.NOVEL.name());
		System.out.println("book created !!!!");
		System.out.println("finish !!!!");
}*/
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		//?autoReconnect=true&useSSL=false
	}
}
