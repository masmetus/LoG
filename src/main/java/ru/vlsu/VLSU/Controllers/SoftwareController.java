package ru.vlsu.VLSU.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vlsu.VLSU.persist.Installedsoftware;
import ru.vlsu.VLSU.persist.Software;
import ru.vlsu.VLSU.persist.SoftwareRepository;

import java.util.List;

@Controller
public class SoftwareController {

    @Autowired
    private SoftwareRepository softwareRepository;


    @GetMapping("/software")
    public String softwareList(Software software, Model model){
        List<Software> softwares = softwareRepository.findAll();
        model.addAttribute("softwares", softwares);
        return "software";
    }


    @GetMapping("/software/softwareCreate")
    public String softwareCreateForm(Software software) {
        return "softwareCreate";
    }

    @PostMapping("/software/softwareCreate")
    public String softwareCreate(Software software, Model model) {
        try {
            softwareRepository.save(software);
            return "redirect:/software";
        }
        catch (Exception ex){
            model.addAttribute("Error", "Такая программа уже есть в списке");
            return "softwareCreate";
        }
    }

    @GetMapping("/software/softwareDelete/{id}")
    public String deleteComputer(@PathVariable("id") Integer id){
        softwareRepository.deleteById(id);
        return "redirect:/software";
    }

    @GetMapping("/software/softwareEdit/{id}")
    public String softwareEditForm(@PathVariable("id") Integer id, Model model){
        Software software = softwareRepository.findById(id).get();
        model.addAttribute("software", software);
        return "softwareEdit";
    }


    @PostMapping("/software/softwareEdit/{id}")
    public String softwareEdit(@PathVariable("id") Integer id, Software software, Model model){
        try {
            softwareRepository.save(software);
            return "redirect:/software";
        }
        catch (Exception ex){
            model.addAttribute("Error", "Такая программа уже есть в списке");
            return "softwareEdit";
        }
    }
}
