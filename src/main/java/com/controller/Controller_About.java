package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_About {
    @GetMapping( "home/about")
    public String about(){
        return "about";
    }
}
