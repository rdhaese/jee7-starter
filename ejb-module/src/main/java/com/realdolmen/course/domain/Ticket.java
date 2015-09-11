package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by RDEAX37 on 10/09/2015.
 */
@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
   // private Passenger passenger;
    private double price;
    @Enumerated (value = EnumType.STRING)
    private Status status;
    @ManyToOne
    private Flight flight;
    @ManyToOne (cascade = CascadeType.ALL)
    private Passenger passenger;

    /*Used y JPA*/
    protected Ticket(){
    }

    public Ticket(double price){
        this(price, null);
    }

    public Ticket(double price, Status status){
        this(price, status, null);
    }

    public Ticket(double price, Status status, Flight flight){
        setPrice(price);
        this.status = status;
        this.flight = flight;
    }

    public Long getId(){
        return id;
    }

    public void setPrice(double price){
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }


    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
