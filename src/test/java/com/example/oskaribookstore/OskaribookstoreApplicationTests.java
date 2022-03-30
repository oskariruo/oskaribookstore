package com.example.oskaribookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.oskaribookstore.web.BookController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class OskaribookstoreApplicationTests {

	@Autowired
	 private BookController controller;
	 @Test
	 public void contextLoads() throws Exception {
	 assertThat(controller).isNotNull();
	 }
	 
	 
}
