package com.example.demo.controller;


import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    /*@Value("${msg}")
    public String msg;*/

    BookRepository bookRepository;

    @Autowired
    AppController(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    @GetMapping("/")
    public ModelAndView getIndexPage(){
        ModelAndView mv = new ModelAndView("index");
        //mv.addObject("msg", msg);
        return mv;
    }
}
