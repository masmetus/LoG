package ru.vlsu.VLSU.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.vlsu.VLSU.persist.*;

import java.util.List;

@Controller
public class ComputerController {

    @Autowired
    private ComputerRepository computerRepository;
    @Autowired
    private InstalledsoftwareRerository installedsoftwareRerository;

    @GetMapping("/Computers")
    public String computerPage (Model model){
        List<Computer> computers = computerRepository.findAll();
        model.addAttribute("computers", computers);
        return "computers";
    }

    @GetMapping("room-details/computer-details/{id}")
    public String computerDetails(@PathVariable("id") Integer id, Model model){
        List<Installedsoftware> installedsoftwares = computerRepository.findById(id).get().getInstalledsoftwares();
        model.addAttribute("installedsoftwares", installedsoftwares);
        return "computer-details";
    }
}
