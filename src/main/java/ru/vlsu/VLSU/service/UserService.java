package ru.vlsu.VLSU.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vlsu.VLSU.persist.Role;
import ru.vlsu.VLSU.persist.User;
import ru.vlsu.VLSU.persist.UserRepository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;


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
        user.setRoles(Collections.singleton(new Role(2L, "Test")));
        repository.save(user);
    }

    public List<User> allUsers() {
        return repository.findAll();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public User saveUser(User user){
        return repository.save(user);
    }

}