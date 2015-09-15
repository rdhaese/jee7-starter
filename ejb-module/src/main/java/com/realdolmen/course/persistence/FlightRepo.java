package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Flight;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by RDEAX37 on 15/09/2015.
 */
@Stateless
@LocalBean
public class FlightRepo {

    @PersistenceContext
    private EntityManager em;

    public List<Flight> findAll(){
        return em.createQuery("SELECT f FROM Flight f", Flight.class).getResultList();
    }
}
