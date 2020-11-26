package com.springweb.application.springwebmvc.controller;

import com.springweb.application.springwebmvc.model.Book;
import com.springweb.application.springwebmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String init(Model model){
        model.addAttribute("books", bookService.findAllBooks());
        return "index";
    }

    @GetMapping("/newBook")
    public String registerForm(Model model){
        model.addAttribute("book", new Book());
        return "newBook";
    }

    @PostMapping("/insertBook")
    public String insertBook(Book book, Model model){
        Book _book = new Book();
        _book.setBookName(book.getBookName());
        _book.setAuthor(book.getAuthor());
        _book.setPurchase_date(book.getPurchase_date());
        bookService.insertBook(_book);
        model.addAttribute("success", true);
        return "newBook";
    }

    @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Integer id, Model model){
        bookService.delete(id);
        model.addAttribute("success", true);
        return "redirect:/";
    }

    @RequestMapping(value = "/editBook/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable Integer id, Model model){
        Collection<Book> colBook = bookService.findBookByID(id);
        for(Book e : colBook){
            model.addAttribute("dataBooks", e);
        }
        return "editBook";
    }

    @PostMapping(value = "/edit")
    public String edit(Book dataBooks, Model model){
        bookService.edit(dataBooks, dataBooks.getId());
        model.addAttribute("success", true);
        return "redirect:/";
    }

}
