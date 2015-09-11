package com.realdolmen.course.domain;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by RDEAX37 on 11/09/2015.
 */
@Stateless
@LocalBean
public class PassengerEJB implements PassengerEJBRemote{

    @PersistenceContext (unitName="MyPersistenceUnit")
    private EntityManager em;

    @Override
    public List<Passenger> findPassengers() {
        return em.createNamedQuery("Passenger.getAllPassengers").getResultList();
    }

    @Override
    public Passenger findPassengerById(Long id) {
        return em.find(Passenger.class, id);
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        em.persist(passenger);
        return passenger;
    }

    @Override
    public void deletePassenger(Passenger passenger) {
            em.remove(em.merge(passenger));
    }

    @Override
    public Passenger updatePassenger(Passenger passenger){
        return em.merge(passenger);
    }
}
