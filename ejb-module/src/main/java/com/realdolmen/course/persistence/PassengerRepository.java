package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Collection;
import java.util.List;

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
       return em.createQuery("SELECT p FROM Passenger p WHERE p.ssn = :ssn", Passenger.class).setParameter("ssn", s).getSingleResult();
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

    public List<Passenger> findAll(){
        return em.createNamedQuery("Passenger.getAllPassengers").getResultList();
    }

    public List<String> findAllLastNames(){
        return em.createQuery("SELECT p.lastName From Passenger p").getResultList();
    }

    public long totalFrequentFlyerMiles(){
        return em.createQuery("SELECT SUM(p.frequentFlyerMiles) FROM Passenger p", Long.class).getSingleResult();
    }

    public Collection<Ticket> findTicketsByPassengerId(long id){
            return em.createQuery("SELECT t FROM Passenger p JOIN p.tickets t WHERE p.id = :id", Ticket.class).setParameter("id", id).getResultList();
    }

    public void deleteAll(){
        //Can't perform following query due to constraints
     /*em.createQuery("DELETE FROM Passenger p").executeUpdate();*/

        for (Passenger p : findAll()){
            delete(p);
        }
    }
}
