package ru.vlsu.VLSU.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vlsu.VLSU.persist.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class InstalledsoftwareController {
    @Autowired
    private InstalledsoftwareRerository installedsoftwareRerository;
    @Autowired
    private SoftwareRepository softwareRepository;
    @Autowired
    private ComputerRepository computerRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/room-details/computer-details/installedsoftwares-delete/{id}")
    public String instalsoftDelete(@PathVariable Integer id, Installedsoftware installedsoftware){
        installedsoftwareRerository.deleteById(id);
        return "redirect:/Rooms";
    }

    @GetMapping("/room-details/computer-details/instalsoftUpdate/{id}")
    public String instalsoftUpdateForm(@PathVariable Integer id, Installedsoftware installedsoftware, Model model){
        Installedsoftware installedsoftwares = installedsoftwareRerository.findById(id).get();
        model.addAttribute("installedsoftware", installedsoftwares);
        model.addAttribute("softwares", softwareRepository.findAll());
        return "instalsoftUpdate";
    }

    @PostMapping("/room-details/computer-details/instalsoftUpdate")
    public String instalsoftUpdate(Installedsoftware installedsoftware, Principal principal){
        installedsoftware.setInstallationDate(new Date(System.currentTimeMillis()));
        //installedsoftware.setComputer(computerRepository.findById(id).get());
        installedsoftwareRerository.save(installedsoftware);
        return "redirect:/room-details/computer-details/3" ;
    }

}
