package ru.vlsu.VLSU.persist;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String RoomNumber;

    //Это вообще бы удалить, но мало ли всё ляжет
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

    public Room(String roomNumber) {
        RoomNumber = roomNumber;
    }
}
