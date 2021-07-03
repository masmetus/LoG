package ru.vlsu.VLSU.persist;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_room")
    private Room room;

    private Integer ID_Computer;

    @ManyToOne
    @JoinColumn(name = "installedsoftware_ID")
    private Software software;

    private boolean request_status;

    private Date application_date;

    private String description_of_the_problem;

    private Date application_closing_date;

    public Request() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Integer getID_Computer() {
        return ID_Computer;
    }

    public void setID_Computer(Integer ID_Computer) {
        this.ID_Computer = ID_Computer;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public boolean isRequest_status() {
        return request_status;
    }

    public void setRequest_status(boolean request_status) {
        this.request_status = request_status;
    }

    public Date getApplication_date() {
        return application_date;
    }

    public void setApplication_date(Date application_date) {
        this.application_date = application_date;
    }

    public String getDescription_of_the_problem() {
        return description_of_the_problem;
    }

    public void setDescription_of_the_problem(String description_of_the_problem) {
        this.description_of_the_problem = description_of_the_problem;
    }

    public Date getApplication_closing_date() {
        return application_closing_date;
    }

    public void setApplication_closing_date(Date application_closing_date) {
        this.application_closing_date = application_closing_date;
    }
}
