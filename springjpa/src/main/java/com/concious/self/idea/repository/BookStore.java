package com.concious.self.idea.repository;

import org.springframework.data.repository.CrudRepository;

import com.concious.self.idea.jpa.model.Book;

public interface BookStore extends CrudRepository<Book, Integer> {

}
