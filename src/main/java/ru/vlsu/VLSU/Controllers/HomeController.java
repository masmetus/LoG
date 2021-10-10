package ru.vlsu.VLSU.Controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/")
    public String homePage(){
        return "index";
    }
}
