package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RDEAX37 on 10/09/2015.
 */
@Entity
public class Flight extends AbstractEntity {

    @OneToMany (mappedBy = "flight")
    private List<Ticket> tickets = new ArrayList<Ticket>();
    @ManyToOne
    private Plane plane;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;



    /*Used by JPA*/
    protected Flight(){}

    public Flight(Ticket... tickets) {
       for (Ticket ticket : tickets){
           this.tickets.add(ticket);
       }
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
