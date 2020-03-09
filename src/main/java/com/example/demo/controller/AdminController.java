package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.validator.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Controller
public class AdminController {

    BookService bookService;
    BookValidator bookValidator;

    @Autowired
    public AdminController(BookService bookService, BookValidator bookValidator){
        this.bookService = bookService;
        this.bookValidator=bookValidator;
    }

    @InitBinder("book")
    protected void initbinder(WebDataBinder dataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, null,  new CustomDateEditor(dateFormat, true));
        dataBinder.setValidator(bookValidator);
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
    public ModelAndView addBook(@ModelAttribute("book") @Valid Book book, BindingResult result){
        ModelAndView mv = new ModelAndView("redirect:/admin");
        if(result.hasErrors()){
            mv.setViewName("admin/library/addBook");
            mv.addObject("book", book);
            return mv;
        }
        bookService.saveBook(book);
        mv.addObject("book", new Book());
        return mv;
    }


}
