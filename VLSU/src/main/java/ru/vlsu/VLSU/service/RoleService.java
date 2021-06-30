package ru.vlsu.VLSU.service;


import org.springframework.stereotype.Service;
import ru.vlsu.VLSU.persist.RoleRepository;

import javax.transaction.Transactional;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}

