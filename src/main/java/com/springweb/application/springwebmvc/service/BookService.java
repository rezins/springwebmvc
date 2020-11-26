package com.springweb.application.springwebmvc.service;

import com.springweb.application.springwebmvc.model.Book;
import com.springweb.application.springwebmvc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Collection<Book> findAllBooks(){
        List<Book> books = new ArrayList<Book>();
        for(Book book : bookRepository.findAll()){
            books.add(book);
        }
        return books;
    }

    public Collection<Book> findBookByID(Integer id){
        List<Book> books = new ArrayList<>();
        Optional<Book> book = bookRepository.findById(id);
        books.add(book.get());
        return books;
    }

    public void delete(Integer id){
        bookRepository.deleteById(id);
    }

    public void insertBook(Book book){
        bookRepository.save(book);
    }

    public void edit(Book book, Integer id){
        Optional<Book> bookObj = bookRepository.findById(id);
        Book realBook = bookObj.get();
        realBook.setBookName(book.getBookName());
        realBook.setAuthor(book.getAuthor());
        realBook.setPurchase_date(book.getPurchase_date());
        bookRepository.save(realBook);
    }

}
