package ru.vlsu.VLSU.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vlsu.VLSU.persist.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class ComputerController {

    @Autowired
    private ComputerRepository computerRepository;
    @Autowired
    private InstalledsoftwareRerository installedsoftwareRerository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private UserRepository userRepository;

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


    @GetMapping("/room-details/computer-details/saveRequest/{id}")
    public String saveRequestFrom(@PathVariable("id") Integer id, Principal principal, Model model){
        model.addAttribute("request", new Request());
        model.addAttribute("installedsoftwaresid", id);
        return "saveRequest";
    }



    @PostMapping("/room-details/computer-details/saveRequest/{id}")
    public String saveRequest(@PathVariable("id") Integer id, Request request, Model model, Principal principal){
        Installedsoftware installedsoftware = installedsoftwareRerository.findById(id).get();
        request.setSoftware(installedsoftware.getSoftware());
        request.setID_Computer(installedsoftware.getComputer().getINV());
        request.setRoom(installedsoftware.getComputer().getWorkplace().getRoom());
        request.setApplication_date(new Date(System.currentTimeMillis()));
        request.setUser(userRepository.findByUsername(principal.getName()).get());
        installedsoftware.setWorkStatus(false);
        request.setRequest_status(true);
        requestRepository.save(request);
        return computerDetails(installedsoftware.getComputer().getId(), model);
    }

    @GetMapping("/room-details/computer-details/saveSoft/{id}")
    public  String saveSoftForm(@PathVariable ("id") Integer id, Model model){

        model.addAttribute("computerid", id);
        return "saveSoftForm";
    }

    @PostMapping("/room-details/computer-details/saveSoft/{id}")
    public String saveSoft(@PathVariable("id") Integer id, Model model){
        Installedsoftware installedsoftware = installedsoftwareRerository.findById(id).get();

        installedsoftwareRerository.save(installedsoftware);
        return computerDetails(installedsoftware.getComputer().getId(), model);
    }




}
