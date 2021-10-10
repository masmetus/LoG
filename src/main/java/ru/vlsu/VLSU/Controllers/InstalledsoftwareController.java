package ru.vlsu.VLSU.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.vlsu.VLSU.persist.Installedsoftware;
import ru.vlsu.VLSU.persist.InstalledsoftwareRerository;
import ru.vlsu.VLSU.persist.Workplace;

@Controller
public class InstalledsoftwareController {
    @Autowired
    private InstalledsoftwareRerository installedsoftwareRerository;


    @GetMapping("/room-details/computer-details/installedsoftwares-delete/{id}")
    public String instalsoftDelete(@PathVariable Integer id, Installedsoftware installedsoftware){
        installedsoftwareRerository.deleteById(id);
        return "redirect:/Rooms";
    }

}
