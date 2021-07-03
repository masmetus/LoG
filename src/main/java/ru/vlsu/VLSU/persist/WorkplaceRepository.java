package ru.vlsu.VLSU.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkplaceRepository extends JpaRepository<Workplace, Integer> {


    List<Workplace> findByRoomId(Integer id);
}
