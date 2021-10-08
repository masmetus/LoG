package ru.vlsu.VLSU.persist;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_room")
    private Room room;

    private Integer ID_Computer;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "installedsoftware_ID")
    private Installedsoftware installedsoftware;

    private boolean requestStatus;

    private Date application_date;

    private String title_of_the_problem;

    private Date application_closing_date;

    private Integer id_who_close;

    @ManyToOne
    @JoinColumn(name = "ID_user")
    private User user;

    private String description_of_the_problem;


    public Request() {
    }

    public Integer getId_who_close() {
        return id_who_close;
    }

    public void setId_who_close(Integer id_who_close) {
        this.id_who_close = id_who_close;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription_of_the_problem() {
        return description_of_the_problem;
    }

    public void setDescription_of_the_problem(String description_of_the_problem) {
        this.description_of_the_problem = description_of_the_problem;
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

    public Installedsoftware getInstalledsoftware() {
        return installedsoftware;
    }

    public void setInstalledsoftware(Installedsoftware installedsoftware) {
        this.installedsoftware = installedsoftware;
    }

    public boolean isRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(boolean requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Date getApplication_date() {
        return application_date;
    }

    public void setApplication_date(Date application_date) {
        this.application_date = application_date;
    }

    public String getTitle_of_the_problem() {
        return title_of_the_problem;
    }

    public void setTitle_of_the_problem(String title_of_the_problem) {
        this.title_of_the_problem = title_of_the_problem;
    }

    public Date getApplication_closing_date() {
        return application_closing_date;
    }

    public void setApplication_closing_date(Date application_closing_date) {
        this.application_closing_date = application_closing_date;
    }


}
