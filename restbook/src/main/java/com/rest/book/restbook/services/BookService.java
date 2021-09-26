package com.rest.book.restbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.rest.book.restbook.Entities.Book;

import org.springframework.stereotype.Component;
@Component
public class BookService {
    private static List<Book> book=new ArrayList<>();

    static{
        book.add(new Book(12,"java By Parvaiz","parvaiz sajad"));
        book.add(new Book(13,"java By baabji","parvaiz baabji"));
        book.add(new Book(14,"java By marilyn","parvaiz marilyn"));


    }
    public List<Book> getALLBooks(){
        return book;
    }
    
    
    public Book GetBookByID(int id) {
        Book bookk=null;
        try {
           
            bookk=   book.stream().filter(i-> i.getId()==id).findFirst().get();
             
        } catch (Exception e) {
    
            e.printStackTrace();
        }
        return bookk;
    }
    public Book AddBook(Book b){
        try {
            book.add(b); 
        } catch (Exception e) {
    
            e.printStackTrace();
        }
     
    System.out.println("added");
    return b;
    }

  


    public void DeleteBook(int id) {
        book= book.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
   
    }


    public Book updateBook(Book boo,int id) {
       book.stream().map(m->{if(m.getId()==id){
m.setTitle(boo.getTitle());
m.setAuthor(boo.getAuthor());
       }
       return m;
    }).collect(Collectors.toList());
    return boo;
  
     
    }
}
