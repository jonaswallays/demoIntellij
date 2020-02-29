package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    BookService bookService;

    @Autowired
    public AdminController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping("/admin")
    public ModelAndView getAdminPage(){
        ModelAndView mv = new ModelAndView("admin/index");
        return mv;
    }

    @GetMapping("/admin/addBook")
    public ModelAndView getAdminAddPage(){
        ModelAndView mv = new ModelAndView("admin/library/addBook");
        mv.addObject("book", new Book());
        return mv;
    }

    @PostMapping("/admin/addBook")
    public ModelAndView addBook(@ModelAttribute("book") Book book){
        ModelAndView mv = new ModelAndView("redirect:/admin");
        bookService.saveBook(book);
        mv.addObject("book", new Book());
        return mv;
    }


}
