package ru.vlsu.VLSU.Controllers;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.VLSU.persist.*;
import ru.vlsu.VLSU.service.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class LogControllers {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public LogControllers(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/users")
    public String UsersPage(Model model, Role role){
        List<User> users = userRepository.findAll();
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("roles", roles);
        return "users";
    }


    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/userUpdate/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userRepository.findById(id).get();
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("user", user);
        model.addAttribute("pageTitle","Редактировать информацию");
        model.addAttribute("roles", roles);
        return "userUpdate";
    }

    @PostMapping("/userUpdate")
    public String updateUser( User user, Role role){
        userRepository.save(user);
        return "redirect:/users";
    }

}
