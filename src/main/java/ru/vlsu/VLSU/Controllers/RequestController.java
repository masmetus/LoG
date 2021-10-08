package ru.vlsu.VLSU.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private InstalledsoftwareRerository installedsoftwareRerository;

    @GetMapping("/RequestList")
    public String requestIndex (Model model){
        List<Request> requestList = requestRepository.findAll(Sort.by(Sort.Direction.DESC, "requestStatus"));
        model.addAttribute("requestList", requestList);
        return "requestList";
    }


    @PostMapping("/closeRequest/{id}")
    public String closeRequest(@PathVariable("id") Integer id, Model model, Principal principal, User user){
        Request request = requestRepository.findById(id).get();
        request.setRequestStatus(false);
        request.getInstalledsoftware().setWorkStatus(true);
        request.setApplication_closing_date(new Date(System.currentTimeMillis()));
        requestRepository.save(request);
        return "redirect:/RequestList";
    }

    @GetMapping("request-delete/{id}")
    public String deleteRoom(@PathVariable("id") Integer id){
        requestRepository.deleteById(id);
        return "redirect:/RequestList";
    }



}
