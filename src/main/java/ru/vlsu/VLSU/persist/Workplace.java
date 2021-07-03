package ru.vlsu.VLSU.persist;

import javax.persistence.*;

@Entity
@Table(name = "workplace")
public class Workplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String Number;

    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "computer_id")
    private Computer computer;

    private Integer id_Monitor;

    public Workplace() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Integer getId_Monitor() {
        return id_Monitor;
    }

    public void setId_Monitor(Integer id_Monitor) {
        this.id_Monitor = id_Monitor;
    }
}
