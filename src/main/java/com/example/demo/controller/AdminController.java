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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

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

    @GetMapping("/admin/books")
    public ModelAndView getAllBooks(){
        List<Book> books = bookService.getallBooks();
        ModelAndView mv = new ModelAndView("admin/library/allBooks");
        mv.addObject("books", books);
        return mv;
    }

    @GetMapping("/admin/library/editbookinfo/{isbin}")
    public ModelAndView getEditPage(@PathVariable("isbin") String isbin){
        ModelAndView mv = new ModelAndView("admin/library/editbookinfo");
        Book book = bookService.findByIsbin(isbin);
        mv.addObject("book", book);
        return mv;
    }

    @PostMapping("/admin/library/editbookinfo/{isbin}")
    public ModelAndView updateBook(@PathVariable("isbin") String isbin, @ModelAttribute("book") @Valid Book bookNew, BindingResult result){
        ModelAndView mv = new ModelAndView("redirect:/admin/books");
        if(result.hasErrors()){
            mv.setViewName("admin/library/editbookinfo");
            mv.addObject("book", bookNew);
            return mv;
        }
        else{
            Book bookOld = bookService.findByIsbin(isbin);
            bookNew.setId(bookOld.getId());
            bookService.saveBook(bookNew);
            return mv;
        }
    }

    @PostMapping("/admin/library/deleteBook/{isbin}")
    public ModelAndView deleteBook(@PathVariable("isbin") String isbin){
        ModelAndView mv = new ModelAndView("redirect:/admin/books");
        bookService.deleteBookByIsbin(isbin);
        return mv;
    }
}
