package com.concious.self.idea.controller;

import org.springframework.web.bind.annotation.RestController;

import com.concious.self.idea.jpa.model.Book;
import com.concious.self.idea.repository.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BooksController {

    private BookStore bookStore;

    @Autowired
    public void RestController(BookStore bookStore) {
        this.bookStore = bookStore;
    }

    @PostMapping(value = "/addbook")
    public Book postMethodName(@RequestBody Book entity) {
        return bookStore.save(entity);
    }

}
