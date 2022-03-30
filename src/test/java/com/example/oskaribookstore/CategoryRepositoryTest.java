package com.example.oskaribookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.oskaribookstore.model.Category;
import com.example.oskaribookstore.model.CategoryRepository;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository repository;

	@Test
	public void findCategory() {
		List<Category> category = repository.findByName("Horror");
		assertThat(category.get(0).getName()).isEqualTo("Horror");
	}

	@Test
	public void createCategory() {
		Category category = new Category("Romance");
		repository.save(category);
		assertThat(!category.getName().isEmpty());
	}

	@Test
	public void deleteCategory() {
		Category category = new Category("Romance");
		repository.deleteById(category.getCategoryid());
		assertThat(category.getBooks().isEmpty());
	}
}
