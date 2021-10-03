package ru.vlsu.VLSU.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vlsu.VLSU.persist.*;

import java.util.List;

@Controller
public class WorkplaceController {

    @Autowired
    private WorkplaceRepository workplaceRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ComputerRepository computerRepository;

    @GetMapping("/workplaceList")
    public String listWorkplace(Model model){
        List<Workplace> workplaceList = workplaceRepository.findAll();
        List<Computer> computers = computerRepository.findAll();
        model.addAttribute("workplaceList", workplaceList);
        model.addAttribute("computer", computers);
        return "workplaceList";
    }

    @GetMapping("/workplaces-create/{id}")
    public String workplacesAddForm(Workplace workplace,Computer computer, Model model){
        List<Room> rooms = roomRepository.findAll();
        List<Computer> computers = computerRepository.findAll();
        //Workplace workplace = new Workplace();
        model.addAttribute("room", rooms);
        model.addAttribute("computer", computers);
        return "workplaces-create";
    }

    @PostMapping("/workplaces-create")
        public String workplaceAdd(Workplace workplace){
        workplaceRepository.save(workplace);
        return "redirect:workplaceList";
    }

    /*@GetMapping("workplace-delete/{id}")
    public String deleteWorkplace(@PathVariable("id") Integer id){
        workplaceRepository.deleteById(id);
        return "redirect:/room-details/{id}";
    }

    @GetMapping("workplace-update/{id}")
    public String roomUpdateForm(@PathVariable("id") Integer id, Model model){
        Workplace workplace = workplaceRepository.findById(id).get();
        model.addAttribute("workplace", workplace);
        return "workplace-update";
    }

    @PostMapping("/room-update")
    public String updateRoom(Workplace workplace){
        workplaceRepository.save(workplace);
        return "workplace-update/{id}";
    }*/

    /*@GetMapping("/room-details/workplaces-details/{id}")
    public String workplaceDetails(@PathVariable("id") Integer id, Model model){
        Workplace workplaces = workplaceRepository.findById(id).get();
        Computer computers = workplaceRepository.findById(id).get().getComputer();
        model.addAttribute("computers", computers);
        model.addAttribute("workplaces", workplaces);
        return "workplace-details";
    }*/
}
