package ru.vlsu.VLSU.persist;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "software")
public class Software {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String Name;

    @OneToMany(mappedBy = "software")
    private List<Installedsoftware> installedsoftwares;

    private Integer ID_Company;

    private Integer ID_Category;

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

    public Integer getID_Company() {
        return ID_Company;
    }

    public void setID_Company(Integer ID_Company) {
        this.ID_Company = ID_Company;
    }

    public Integer getID_Category() {
        return ID_Category;
    }

    public void setID_Category(Integer ID_Category) {
        this.ID_Category = ID_Category;
    }
}
