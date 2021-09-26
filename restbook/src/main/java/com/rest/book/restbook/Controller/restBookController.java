package com.rest.book.restbook.Controller;


import java.util.List;
import java.util.Optional;

import com.rest.book.restbook.Entities.Book;

import com.rest.book.restbook.services.bookServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restBookController {

    /**
     * public Book getBook(){
     * 
     * Book book2 =new Book();
     * 
     * book2.setId(1); book2.setAuthor("parvaiz"); book2.setTitle("java by
     * parvaiz"); return book2; }
     */
    @Autowired
    private bookServices bookService;
   

     @GetMapping("/book/{id}")
     public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
       Book bookSingle = bookService.GetBookByID(id);
       if( bookSingle==null){
return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       return ResponseEntity.of(Optional.of(bookSingle));
     }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAlBooks(){

        List<Book> list1= bookService.getALLBooks();
        if(list1.size()<=0){
       return     ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        return ResponseEntity.of(Optional.of(list1));
    }

    @PostMapping("/addBook")
        public ResponseEntity<Book> addBookhandler(@RequestBody Book b){
            Book bpost=null;
            try {
                bpost=   bookService.AddBook(b);
        
                System.out.println(bpost);
                return ResponseEntity.status(HttpStatus.CREATED).build(); 
            } catch (Exception e) {

return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
 
        }
 @DeleteMapping("/delBook/{bid}")
 public ResponseEntity<Void> delBook(@PathVariable("bid") int id){
     try {
        bookService.DeleteBook(id);  
        return ResponseEntity.status(HttpStatus.OK).build();
     } catch (Exception e) {

         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }
    
 }

 @PutMapping("/update/{id}")
 public ResponseEntity<Book> UpdateBook(@RequestBody Book book,@PathVariable("id") int id){

     try {
        book=bookService.updateBook(book,id);  
        return ResponseEntity.status(HttpStatus.OK).build();
     } catch (Exception e) {
 
         e.printStackTrace();
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }
    


 }

        
    }

