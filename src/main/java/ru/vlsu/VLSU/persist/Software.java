package ru.vlsu.VLSU.persist;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "software")
public class Software {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2)
    @NotBlank
    private String Name;

    @OneToMany(mappedBy = "software", cascade = CascadeType.ALL )
    private List<Installedsoftware> installedsoftwares;


    public Software() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
