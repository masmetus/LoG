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

    @GetMapping("/room-details/workplaces-create/{id}")
    public String workplacesAddForm( Workplace workplace,Computer computer, Model model){
        List<Room> rooms = roomRepository.findAll();
        List<Computer> computers = computerRepository.findAll();
        //Workplace workplace = new Workplace();
        model.addAttribute("room", rooms);
        model.addAttribute("computer", computers);
        return "room-details" ;
    }

    @GetMapping("/room-details/workplaces-delete/{id}")
    public String workplaceDelete(@PathVariable Integer id,Workplace workplace, Computer computer){
        workplaceRepository.deleteById(id);
        return "redirect:/Rooms";
    }

}
