package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerId;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.persistence.PersistenceException;

/**
 * Created by RDEAX37 on 9/09/2015.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest{

    @Rule
    public ExpectedException expector = ExpectedException.none();

    @Test
    public void passengerCanBePersisted() throws Exception {
        Passenger passenger = new Passenger("1234" , "Robin", "DHaese", 10);
        entityManager().persist(passenger);
        assertNotNull(passenger.getPassengerId().getSsn());
    }

    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedPassengerId() throws Exception {
        Passenger passenger = new Passenger(null, "testFName", "testLName", 10);
        passenger.setPassengerId(null);
        entityManager().persist(passenger);
    }

    @Test
    public void passengerCanBeRetrievedById() throws Exception {
        PassengerId passengerId = new PassengerId("12345", "lname1");
        assertEquals("fname1", entityManager().find(Passenger.class, passengerId).getFirstName());
    }

    @Test
    public void allPassengersCanBeRetrieved() throws Exception {
        assertEquals(3, entityManager().createNamedQuery("Passenger.getAllPassengers").getResultList().size());
    }
}