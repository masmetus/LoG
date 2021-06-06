package ru.vlsu.VLSU.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vlsu.VLSU.persist.User;
import ru.vlsu.VLSU.persist.UserRepository;


@Service
public class UserService {


    private final UserRepository repository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, BCryptPasswordEncoder passwordEncoder){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public void create(UserRep userRep) {
        User user = new User();
        user.setUsername(userRep.getUsername());
        user.setPassword(passwordEncoder.encode(userRep.getPassword()));
        repository.save(user);
    }
}
