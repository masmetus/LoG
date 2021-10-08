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
    @Autowired
    private WorkplaceRepository workplaceRepository;
    @Autowired
    private SoftwareRepository softwareRepository;


    @GetMapping("/Computers")
    public String computerPage (Model model){
        List<Computer> computers = computerRepository.findAll();
        model.addAttribute("computers", computers);
        return "computers";
    }

    @GetMapping("/computerCreate")
    public String computerCreateForm(Computer computer){
        return "computerCreate";
    }

    @PostMapping("/computerCreate")
    public String computerCreate(Computer computer, Model model){
        try {
            computer.setWorking(true);
            computerRepository.save(computer);
            return "redirect:/Computers";
        }
        catch (Exception ex){
            model.addAttribute("Error", "Компьютер с таким Инв. номером уже существует");
            return "computerCreate";
        }
    }

    @GetMapping("room-details/computer-details/{id}")
    public String computerDetails(@PathVariable("id") Integer id, Model model){
        model.addAttribute("computerId", id);
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
        request.setInstalledsoftware(installedsoftware);
        request.setID_Computer(installedsoftware.getComputer().getINV());
        request.setRoom(installedsoftware.getComputer().getWorkplace().getRoom());
        request.setApplication_date(new Date(System.currentTimeMillis()));
        request.setUser(userRepository.findByUsername(principal.getName()).get());
        installedsoftware.setWorkStatus(false);
        request.setRequestStatus(true);
        requestRepository.save(request);
        return computerDetails(installedsoftware.getComputer().getId(), model);
    }


    @GetMapping("/room-details/computer-details/installSoft/{id}")
    public String installSoftForm(@PathVariable("id") Integer id, Model model){
        model.addAttribute("computerId", id);
        model.addAttribute("Installedsoftware", new Installedsoftware());
        model.addAttribute("softwares", softwareRepository.findAll());

        return "installSoft";
    }

    @PostMapping("/room-details/computer-details/installSoft/{id}")
    public String installSoft(@PathVariable("id") Integer id, Model model, Installedsoftware installedsoftware, Principal principal){
        if(installedsoftwareRerository.findByComputerIdAndSoftwareId(id, installedsoftware.getSoftwareId())!=null){
            model.addAttribute("Error", "ПО уже установленно");
            return installSoftForm(id, model);
        }
        installedsoftware.setId(null);
        installedsoftware.setWorkStatus(true);
        installedsoftware.setSoftware(softwareRepository.findById(installedsoftware.getSoftwareId()).get());
        installedsoftware.setInstallationDate(new Date(System.currentTimeMillis()));
        installedsoftware.setUser(userRepository.findByUsername(principal.getName()).get());
        installedsoftware.setComputer(computerRepository.findById(id).get());
        installedsoftwareRerository.save(installedsoftware);
        return "redirect:/room-details/computer-details/" + id;
    }

    @GetMapping("computer-delete/{id}")
    public String deleteComputer(@PathVariable("id") Integer id){
        computerRepository.deleteById(id);
        return "redirect:/Computers";
    }







}
