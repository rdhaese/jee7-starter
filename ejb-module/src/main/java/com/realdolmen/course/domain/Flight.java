package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RDEAX37 on 10/09/2015.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Flight extends AbstractEntity {

   /* @OneToMany (mappedBy = "flight")
    private List<Ticket> tickets = new ArrayList<Ticket>();*/
    @ManyToOne
    private Plane plane;
    @Temporal(value = TemporalType.DATE)
    private Date departureTime;
    @Temporal(value = TemporalType.DATE)
    private Date arrivalTime;


    /*Used by JPA*/
    protected Flight(){}

   /* public Flight(Ticket... tickets) {
       for (Ticket ticket : tickets){
           this.tickets.add(ticket);
       }
    }*/

   /* public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

   /* public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }*/
}
