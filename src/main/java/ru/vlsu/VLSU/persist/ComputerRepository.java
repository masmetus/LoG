package ru.vlsu.VLSU.persist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {
    List<Computer> findByWorkplace(Workplace workplace);

}
