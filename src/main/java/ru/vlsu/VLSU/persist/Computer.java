package ru.vlsu.VLSU.persist;


import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "computer")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private Integer INV;

    @OneToOne(cascade = CascadeType.ALL ,mappedBy = "computer")
    private Workplace workplace;

    @NotBlank
    private boolean isWorking;


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

}
