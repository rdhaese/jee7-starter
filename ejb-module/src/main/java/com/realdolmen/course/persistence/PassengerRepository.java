package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created by RDEAX37 on 10/09/2015.
 */
public class PassengerRepository {


    EntityManager em;

    public PassengerRepository(EntityManager em){
        this.em = em;
    }

    public void add(Passenger passenger) {
        em.persist(passenger);
    }

    public Passenger getOnSSN(String s) {
       return em.createQuery(String.format("SELECT p FROM Passenger p WHERE p.ssn = %s", s), Passenger.class).getSingleResult();
    }

    public Passenger getOnId(long id) {
        Passenger p = em.find(Passenger.class, id);
        return p;
    }

    public void update(Passenger passenger) {
        em.merge(passenger);
    }

    public void delete(Passenger passenger) {
        em.remove(em.merge(passenger));
    }

    public Passenger refresh(Passenger passenger) {
        em.refresh(passenger);
        return passenger;
    }
}
