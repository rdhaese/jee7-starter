package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Schedule;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by RDEAX37 on 14/09/2015.
 */
@Remote
@LocalBean
public class FlightReminderEJB {

    @PersistenceContext (name = "myPersistenceContext")
    private EntityManager em;

    @Schedule ()
    public void remindPassengers(){
        List<Passenger> passengers = em.createQuery("SELECT p FROM Passenger p").getResultList();
        for (Passenger passenger : passengers){
            sendEmail(passenger);
        }
    }

    private void sendEmail(Passenger passenger){
        System.out.println(String.format("Send mail to: %s %s", passenger.getFirstName(), passenger.getLastName()));
    }
}
