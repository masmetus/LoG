package ru.vlsu.VLSU.persist;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "computer")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String INV;

    @OneToOne(mappedBy = "computer")
    private Workplace workplace;

    private Integer ID_computerType;

    private boolean isWorking;

    private Integer id_component;

    @OneToMany(mappedBy = "computer")
    private List<Installedsoftware> installedsoftwares;

    public Computer() {
    }

    public List<Installedsoftware> getInstalledsoftwares() {
        return installedsoftwares;
    }

    public void setInstalledsoftwares(List<Installedsoftware> installedsoftwares) {
        this.installedsoftwares = installedsoftwares;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getINV() {
        return INV;
    }

    public void setINV(String INV) {
        this.INV = INV;
    }

    public Workplace getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Workplace workplace) {
        this.workplace = workplace;
    }

    public Integer getID_computerType() {
        return ID_computerType;
    }

    public void setID_computerType(Integer ID_computerType) {
        this.ID_computerType = ID_computerType;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public Integer getId_component() {
        return id_component;
    }

    public void setId_component(Integer id_component) {
        this.id_component = id_component;
    }
}
