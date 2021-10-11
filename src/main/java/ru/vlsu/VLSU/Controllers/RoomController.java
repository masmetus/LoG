package ru.vlsu.VLSU.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vlsu.VLSU.persist.*;

import java.util.List;
import java.util.Optional;

@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private WorkplaceRepository workplaceRepository;
    @Autowired
    private ComputerRepository computerRepository;
    @Autowired
    private SoftwareRepository softwareRepository;


    @GetMapping("/Rooms")
    public String roomPage (Model model){
        List<Room> rooms = roomRepository.findAll();
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

    @GetMapping("/room-create")
    public String roomAddForm(Room room){
        return "room-create";
    }

    @PostMapping("/room-create")
    public String roomAdd(Room room, Model model){
        try {
            roomRepository.save(room);
            return "redirect:/Rooms";
        }
        catch (Exception ex){
            model.addAttribute("Error", "Кабинет уже существует");
            return "room-create";
        }
    }

    @GetMapping("room-delete/{id}")
    public String deleteRoom(@PathVariable("id") Integer id){
        roomRepository.deleteById(id);
        return "redirect:/Rooms";
    }

    @GetMapping("room-update/{id}")
    public String roomUpdateForm(@PathVariable("id") Integer id, Model model){
        Room rooms = roomRepository.findById(id).get();
        model.addAttribute("room", rooms);
        return "room-update";
    }

    @PostMapping("/room-update")
    public String updateRoom(Room room, Model model){
        try {
            roomRepository.save(room);
            return "redirect:/Rooms";
        }
        catch (Exception ex){
            model.addAttribute("Error", "Кабинет с таким номером уже существует");
            return "room-update";
        }
    }

    @GetMapping("room-details/{id}")
    public String roomDetails(@PathVariable("id") Integer id, Model model){
        List<Workplace> workplaces = roomRepository.findById(id).get().getWorkplaces();
        List<Computer> computers = computerRepository.findAll();
        model.addAttribute("roomNumber", id);
        model.addAttribute("workplaces", workplaces);
        model.addAttribute("computer", computers);
        return "room-details";
    }


    @GetMapping("/room-details/workplaces-create/{id}")
    public String addWorkplacesForm(@PathVariable("id") Integer id, Model model){
        model.addAttribute("roomNumber", id);
        model.addAttribute("computers", computerRepository.findByWorkplace(null));
        model.addAttribute("workplace", new Workplace());
        return "workplaces-create";
    }

    @PostMapping("/room-details/workplaces-create/{id}")
    public String addWorkplaces (@PathVariable("id") Integer id, Model model, Workplace workplace){
        Room room = roomRepository.findById(id).get();
        workplace.setRoom(room);
        workplace.setComputer(computerRepository.findById(workplace.getComputer_id()).get());
        workplace.setId(null);
        workplaceRepository.save(workplace);
        return roomDetails(room.getId(), model);
    }

   /* @GetMapping("/room-details/workplaseEdit/{id}")
    public String workplaseEditForm(@PathVariable("id") Integer id, Model model){
        Workplace workplace = workplaceRepository.findById(id).get();
        model.addAttribute("roomNumber", id);
        model.addAttribute("computers", computerRepository.findByWorkplace(null));
        model.addAttribute("workplace", workplace);
        return "workplaseEdit";
    }

    @PostMapping("/room-details/workplaseEdit/{id}")
    public String workplaseEdit(@PathVariable("id") Integer id, Model model, Workplace workplace){
        Room room = roomRepository.findById(id).get();
        workplace.setRoom(room);
        workplace.setComputer(computerRepository.findById(workplace.getComputer_id()).get());
        workplace.setId(null);
        workplaceRepository.save(workplace);
        return roomDetails(room.getId(), model);
    } */




}
