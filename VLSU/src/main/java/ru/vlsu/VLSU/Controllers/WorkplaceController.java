package ru.vlsu.VLSU.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vlsu.VLSU.persist.Workplace;
import ru.vlsu.VLSU.persist.WorkplaceRepository;

import java.util.List;

@Controller
public class WorkplaceController {

    @Autowired
    private WorkplaceRepository workplaceRepository;

    @GetMapping("/workplaceList")
    public String listWorkplace(Model model){
        List<Workplace> workplaceList = workplaceRepository.findAll();
        model.addAttribute("workplaceList", workplaceList);
        return "workplaceList";
    }
}
