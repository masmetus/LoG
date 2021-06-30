package ru.vlsu.VLSU.persist;

import javax.persistence.*;

@Entity
@Table(name = "workplace")
public class Workplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String Number;

    private Integer idRoom;

    private Integer id_computer;

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

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public Integer getId_computer() {
        return id_computer;
    }

    public void setId_computer(Integer id_computer) {
        this.id_computer = id_computer;
    }

    public Integer getId_Monitor() {
        return id_Monitor;
    }

    public void setId_Monitor(Integer id_Monitor) {
        this.id_Monitor = id_Monitor;
    }
}
