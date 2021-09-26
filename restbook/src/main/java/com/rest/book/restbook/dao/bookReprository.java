package com.rest.book.restbook.dao;

import com.rest.book.restbook.Entities.Book;

import org.springframework.data.repository.CrudRepository;

public interface bookReprository extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
