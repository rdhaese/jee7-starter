package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RDEAX37 on 10/09/2015.
 */
@Entity
public class Flight implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany (mappedBy = "flight")
    private List<Ticket> tickets = new ArrayList<Ticket>();
    @ManyToOne
    private Plane plane;



    /*Used by JPA*/
    protected Flight(){}

    public Flight(Ticket... tickets) {
       for (Ticket ticket : tickets){
           this.tickets.add(ticket);
       }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
