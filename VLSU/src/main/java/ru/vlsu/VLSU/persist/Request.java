package ru.vlsu.VLSU.persist;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
