package com.realdolmen.course.integration;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerEJBRemote;
import com.realdolmen.course.domain.PassengerType;
import com.realdolmen.course.persistence.RemoteBookRepository;
import org.junit.Before;
import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by RDEAX37 on 11/09/2015.
 */
public class PassengerEJBRemoteTest extends RemoteIntegrationTest {


    private  PassengerEJBRemote passengerRepo;
    @Before
    public void setUp() throws NamingException {
        passengerRepo = lookup("ear-module-1.1/ejb-module-1.1/PassengerEJB!com.realdolmen.course.domain.PassengerEJBRemote");
    }

    @Test
    public void canPassengersBeFound() throws NamingException {
        assertEquals(3, passengerRepo.findPassengers().size());
    }

    @Test
    public void canPassengerBeFoundOnId(){
        assertNotNull(passengerRepo.findPassengerById(1000L));
    }

    @Test
    public void canPassengerBeCreated(){
        Passenger passenger = new Passenger("1234", "testFName", "testLName", 10, null, new Date(), PassengerType.OCCASIONAL, new Date());
        passengerRepo.createPassenger(passenger);
        assertEquals(4, passengerRepo.findPassengers().size());
    }

    @Test
    public void canPassengerBeDeleted(){
        Passenger passenger = passengerRepo.findPassengerById(2000L);
        passengerRepo.deletePassenger(passenger);
        assertNull(passengerRepo.findPassengerById(2000L));
    }

    @Test
    public void canPassengerBeUpdated(){
        Passenger passenger = passengerRepo.findPassengerById(2000L);
        passenger.setFirstName("newFirstName");
        passengerRepo.updatePassenger(passenger);
        assertEquals("newFirstName", passengerRepo.findPassengerById(2000L).getFirstName());
    }

}
