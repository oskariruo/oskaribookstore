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

			
			System.out.println("fetch all books");
			for (Book book : repository.findAll()) {
				System.out.println(book.toString());
			}

		};
	}
}
