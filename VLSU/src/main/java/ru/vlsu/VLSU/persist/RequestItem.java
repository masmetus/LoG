package ru.vlsu.VLSU.persist;

import javax.persistence.ManyToOne;

public class RequestItem {

    @ManyToOne
    private User user;

   /* public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }*/
}
