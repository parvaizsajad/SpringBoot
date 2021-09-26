package com.rest.book.restbook.services;

import java.util.List;

import com.rest.book.restbook.Entities.Book;
import com.rest.book.restbook.dao.bookReprository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class bookServices {
    @Autowired
    private bookReprository bookReprository;

    public List<Book> getALLBooks() {
        return (List<Book>) bookReprository.findAll();
    }

    public Book GetBookByID(int id) {
        Book bookk = null;
        try {

            bookk = bookReprository.findById(id);

        } catch (Exception e) {
       
            e.printStackTrace();
        }
        return bookk;
    }

    public Book AddBook(Book b) {
        try {
            bookReprository.save(b);
        } catch (Exception e) {

            e.printStackTrace();
        }

        System.out.println("added");
        return b;
    }

    public void DeleteBook(int id) {
        bookReprository.deleteById(id);

    }

    public Book updateBook(Book boo, int id) {
        Book bookkl = bookReprository.save(boo);
        return bookkl;

    }
}
