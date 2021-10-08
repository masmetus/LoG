package ru.vlsu.VLSU.persist;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "computer")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer INV;

    @OneToOne(cascade = CascadeType.ALL ,mappedBy = "computer")
    private Workplace workplace;


    private boolean isWorking;

    private Integer id_component;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "computer")
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

    public Integer getINV() {
        return INV;
    }

        public void setINV(Integer INV) {
        this.INV = INV;
    }

    public Workplace getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Workplace workplace) {
        this.workplace = workplace;
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
