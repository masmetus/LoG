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

    @Column(insertable = false, updatable = false)
    private Integer computer_id;


    public Workplace() {
    }

    public Integer getComputer_id() {
        return computer_id;
    }

    public void setComputer_id(Integer computer_id) {
        this.computer_id = computer_id;
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

}
