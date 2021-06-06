package ru.vlsu.VLSU.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vlsu.VLSU.persist.User;
import ru.vlsu.VLSU.service.UserRep;
import ru.vlsu.VLSU.service.UserService;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserRep());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid UserRep userRep, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register";
        }
        if(!userRep.getPassword().equals(userRep.getRepeatPassword())){
            bindingResult.rejectValue("password", "","Пароли не совпадают.");
            return "register";
        }

        userService.create(userRep);
        return "redirect:/login";
    }
}
