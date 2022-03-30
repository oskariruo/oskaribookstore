package com.example.oskaribookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.oskaribookstore.model.User;
import com.example.oskaribookstore.model.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository repository;

	@Test
	public void findUser() {
		User users = repository.findByUsername("user");
		assertThat(users.getEmail()).isEqualTo("user@haaga-helia.fi");
	}

	@Test
	public void createNewUser() {
		User user = new User("tested", "$2a$10$i/AfvSt.ZDf8QpaGvZj7iePh1EdLRs10dK6qMplzRP/vsIExLuAhO",
				"tested@haaga-helia.fi", "USER");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}

	@Test
	public void deleteNewBook() {
		User user = repository.findByUsername("testi");
		repository.delete(user);
		assertThat(user.getId()).isNull();
	}
}
