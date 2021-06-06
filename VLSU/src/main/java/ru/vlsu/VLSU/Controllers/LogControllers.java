package ru.vlsu.VLSU.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogControllers {

    @GetMapping
    public String indexPage(){
        return "Index";
    }
}
