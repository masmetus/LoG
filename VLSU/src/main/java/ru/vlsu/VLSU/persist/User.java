package ru.vlsu.VLSU.persist;

import org.apache.coyote.Request;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

   /* @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<Request> requests;
*/

    public User(){
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

   /* public List<RequestItem> getRequestItem(){
        return requestItem();
    }

    public void setRequestItem(List<RequestItem> requestItem){
        this.requestItem = requestItem;
    }*/

}
