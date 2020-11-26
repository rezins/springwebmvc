package com.springweb.application.springwebmvc.rest;

import com.springweb.application.springwebmvc.model.Book;
import com.springweb.application.springwebmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MainRestController {

    @Autowired
    private BookService bookService;

    @GetMapping("/findAllBooks")
    public Collection<Book> getAllBooks(){
        return bookService.findAllBooks();
    }

    @GetMapping("/deleteBook")
    public void deleteBook(@RequestParam Integer id){
        bookService.delete(id);
    }


}
