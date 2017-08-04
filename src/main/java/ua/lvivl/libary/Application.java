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
	@PostConstruct
		public void init(){
		System.out.println("- - - - - - - - -- - start");
		User user=new User();
		user.setEmail("admin@mail.com");
		user.setPassword("123456");
		user.setFirstName("Admin");
		user.setLastName("Admin");
		user.setPhone("0930000001");
		String u=userService.createUser(user,Role.ADMINISTRATOR.name());
		System.out.println("admin created !!!!");
}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		//?autoReconnect=true&useSSL=false
	}
}
