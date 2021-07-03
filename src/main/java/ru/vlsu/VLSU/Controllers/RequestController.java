package ru.vlsu.VLSU.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vlsu.VLSU.persist.Request;
import ru.vlsu.VLSU.persist.RequestRepository;

import java.util.List;

@Controller
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping("/RequestList")
    public String requestIndex (Model model){
        List<Request> requestList = requestRepository.findAll();
        model.addAttribute("requestList", requestList);
        return "requestList";
    }


}
