package com.example.demo.controller;


import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @GetMapping("app/books")
    public ModelAndView getAllBooks(){
        List<Book> books = bookService.getallBooks();
        ModelAndView mv = new ModelAndView("app/library/allBooks");
        mv.addObject("books", books);
        return mv;
    }

}
