package com.example.oskaribookstore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Service;
@Service
public interface BookRepository extends CrudRepository <Book, Long> {
	List<Book> findByisbn(String isbn);
}
