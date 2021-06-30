package ru.vlsu.VLSU.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vlsu.VLSU.persist.Room;
import ru.vlsu.VLSU.persist.RoomRepository;
import ru.vlsu.VLSU.persist.User;

import java.util.List;
import java.util.Optional;

@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;


    @GetMapping("/Rooms")
    public String roomPage (Model model){
        Iterable<Room> rooms = roomRepository.findAll();
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

    @GetMapping("/room-create")
    public String roomAddForm(Room room){
        return "room-create";
    }

    @PostMapping("/room-create")
    public String roomAdd(Room room){
        roomRepository.save(room);
        return "redirect:/Rooms";
    }

    @GetMapping("room-delete/{id}")
    public String deleteRoom(@PathVariable("id") Long id){
        roomRepository.deleteById(id);
        return "redirect:/Rooms";
    }

    @GetMapping("room-update/{id}")
    public String roomUpdateForm(@PathVariable("id") Long id, Model model){
        Room rooms = roomRepository.findById(id).get();
        model.addAttribute("room", rooms);
        return "room-update";
    }

    @PostMapping("/room-update")
    public String updateRoom(Room rooms){
        roomRepository.save(rooms);
        return "redirect:/Rooms";
    }

    @GetMapping("room-details/{id}")
    public String roomDetails(@PathVariable("id") Long id, Model model){
        return "/room-details";
    }
}
