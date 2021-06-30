package ru.vlsu.VLSU.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vlsu.VLSU.persist.Role;
import ru.vlsu.VLSU.persist.RoleRepository;
import ru.vlsu.VLSU.persist.User;
import ru.vlsu.VLSU.service.RoleService;

import java.util.List;
import java.util.Map;

@Controller
public class RoleController {

    private RoleRepository roleRepository;
    private RoleService roleService;

    @Autowired
    public RoleController(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }


    @GetMapping("/Roles")
    public String rolePage(Model model){
        List<Role> roles;
        roles = roleRepository.findAll();
        model.addAttribute("roles", roles);
        return "roles";
    }

    @GetMapping("/role-create")
    public String createRoleForm(Role role){
        return "role-create";
    }

    @PostMapping("/role-create")
    public String createRole(Role role){
        roleRepository.save(role);
        return "redirect:/Roles";
    }

    @GetMapping("role-delete/{id}")
    public String deleteRole(@PathVariable("id") Long id){
        roleRepository.deleteById(id);
        return "redirect:/Roles";
    }
}
