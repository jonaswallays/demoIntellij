package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    /*@Value("${msg}")
    public String msg;*/

    @GetMapping("/")
    public ModelAndView getIndexPage(){
        ModelAndView mv = new ModelAndView("index");
        //mv.addObject("msg", msg);
        return mv;
    }
}
