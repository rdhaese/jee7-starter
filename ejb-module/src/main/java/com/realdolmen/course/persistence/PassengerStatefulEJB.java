package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.*;

import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

/**
 * Created by RDEAX37 on 14/09/2015.
 */
@Stateful
@LocalBean
public class PassengerStatefulEJB implements PassengerStatefulEJBRemote{

    @PersistenceContext(name="MyPersistenceUnit")
    private EntityManager em;

    private Passenger passenger;

    public Passenger getPassenger(){
        return passenger;
    }

    public void createPassengers(String ssn, String firstName, String lastName, Integer frequentFlyerMiles, byte[] picture, Date dateOfBirth, PassengerType passengerType, Date lastFlight){
        passenger = new Passenger(ssn, firstName, lastName, frequentFlyerMiles, picture, dateOfBirth, passengerType, lastFlight);
    }

    public void pickPassenger(long id){
        passenger = em.find(Passenger.class, id);
    }

    public void setAddress(Address address){
        passenger.setAddress(address);
    }

    public void addCreditCard(CreditCard creditCard){
        passenger.addCreditCard(creditCard);
    }

    public void addTicket(double price, Status status){
        Ticket ticket = new Ticket(price, status);
        ticket.setPassenger(passenger);
        passenger.addTicket(ticket);
    }

    @Remove
    public void checkOut(){
        em.persist(passenger);
    }
}
