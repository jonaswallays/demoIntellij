package com.example.demo.controller;


import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    BookService bookService;

    @Autowired
    public AppController(BookService bookService){
        this.bookService=bookService;
    }

    @GetMapping("/app")
    public ModelAndView getIndexPage(){
        ModelAndView mv = new ModelAndView("app/index");
        //mv.addObject("msg", msg);
        return mv;
    }

    @GetMapping("app/books")
    public ModelAndView getAllBooks(){
        List<Book> books = bookService.getallBooks();
        ModelAndView mv = new ModelAndView("app/library/allBooks");
        mv.addObject("books", books);
        return mv;
    }
}
