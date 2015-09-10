package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.fail;

/**
 * Created by RDEAX37 on 10/09/2015.
 */
public class TicketTest extends DataSetPersistenceTest{

    @Test
    public void testTicketCanBePersisted() throws  Exception {
       Ticket t = new Ticket(50.5);
       entityManager().persist(t);
        assertNotNull(t.getId());
    }

    @Test
    public void ticketCanBeRetreivedFromTheDatabase() throws Exception{
        Ticket ticket = entityManager().find(Ticket.class, 1000L);
        assertTrue(150D == ticket.getPrice());
    }

    /*@Test
    public void flightCanBeAssignedToATicket() throws  Exception {
        Ticket ticket = new Ticket(50d, Status.PURCHASED);
        Flight flight = new DomesticFlight("sabena");
        ticket.setFlight(flight);
        entityManager().persist(ticket);
        assertNotNull(ticket.getFlight().getId());
    }*/

    @Test
    public void passengerCanbeAssignedToATicket() throws Exception {
        Ticket ticket = new Ticket(50d, Status.PURCHASED);
        Passenger passenger = new Passenger("1234", "testFName", "testLName", 10, null, new Date(), PassengerType.OCCASIONAL, new Date());
        ticket.setPassenger(passenger);
        entityManager().persist(ticket);
        assertNotNull(ticket.getPassenger().getId());    }

    @Test (expected = IllegalArgumentException.class)
    public void ticketPriceMustNotBeNegative() throws  Exception {
        Ticket t = new Ticket(-1D);
    }

}
