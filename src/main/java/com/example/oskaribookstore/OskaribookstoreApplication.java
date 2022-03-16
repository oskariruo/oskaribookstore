package com.example.oskaribookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.oskaribookstore.model.Book;
import com.example.oskaribookstore.model.BookRepository;
import com.example.oskaribookstore.model.Category;
import com.example.oskaribookstore.model.CategoryRepository;
import com.example.oskaribookstore.model.User;
import com.example.oskaribookstore.model.UserRepository;

@SpringBootApplication
public class OskaribookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OskaribookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository,
			UserRepository urepository) {
		return (args) -> {

			System.out.println("save a couple of categories");
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Fantasy"));

			System.out.println("save a couple of books");

			repository.save(new Book("Harry Potter", "JK Rowling", 1997, "9780747532743", 19.90,
					crepository.findByName("Fantasy").get(0)));
			repository.save(new Book("The Hobbit", "J. R. R. Tolkien", 1937, "9780044403371", 39.90,
					crepository.findByName("Fantasy").get(0)));
			repository.save(new Book("The Horror book", "Kirjoittaja testi", 9999, "111222333444", 11.99,
					crepository.findByName("Horror").get(0)));
			
			urepository.save(new User("user", "$2a$10$ouDEIiaFcl8sIS1Dq5a27O.q1gI8a47k.BOxfW1P2ZtIc2OWu0HYO", "user@haaga-helia.fi", "USER"));
			urepository.save(new User("admin", "$2a$10$x/QZ0UZKTpuSmGGtKA94Ge9RmB9GxHYCwp7/jbPGwBpcs/LJRWEma", "admin@gmail.com", "ADMIN"));
			urepository.save(new User("testi", "$2a$10$Xt.KkSqo.yxEjWv4ypTGaumw3orGTdw6gdgaF4NCpeNmEpE0.Mz2S", "testi@gmail.com", "USER"));
			
			System.out.println("fetch all books");
			for (Book book : repository.findAll()) {
				System.out.println(book.toString());
			}

		};
	}
}
