package com.example.oskaribookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.oskaribookstore.model.Book;
import com.example.oskaribookstore.model.BookRepository;
import com.example.oskaribookstore.model.Category;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookRepositoryTest {
	@Autowired
	private BookRepository repository;

	@Test
	public void findBook() {
		List<Book> books = repository.findByisbn("9780747532743");

		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Harry Potter");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("Testikirja", "Oskari Ruotsalainen", 1999, "99991999", 66.66,
				new Category("Parhaat kirjat"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void deleteNewBook() {
		Book book = new Book("Test", "Oskari", 1999, "9999", 66.66, new Category("Poisto"));
		repository.save(book);
		repository.delete(book);
		assertThat(book.getId()).isNull();
	}
}
