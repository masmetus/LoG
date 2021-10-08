package ru.vlsu.VLSU.persist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoftwareRepository extends JpaRepository<Software, Integer> {
}
