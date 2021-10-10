package ru.vlsu.VLSU.persist;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  Integer responsible_id;

    private String RoomNumber;

    @OneToMany(mappedBy = "room")
    private List<Request> requests;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Workplace> workplaces;

    public List<Workplace> getWorkplaces() {
        return workplaces;
    }

    public void setWorkplaces(List<Workplace> workplaces) {
        this.workplaces = workplaces;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        RoomNumber = roomNumber;
    }

    public Room() {
    }

    public Integer getResponsible_id() {
        return responsible_id;
    }

    public void setResponsible_id(Integer responsible_id) {
        this.responsible_id = responsible_id;
    }

    public Room(String roomNumber) {
        RoomNumber = roomNumber;
    }
}
