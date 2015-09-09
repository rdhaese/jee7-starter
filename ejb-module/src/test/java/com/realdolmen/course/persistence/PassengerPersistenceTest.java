package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.persistence.PersistenceException;
import java.util.Date;

/**
 * Created by RDEAX37 on 9/09/2015.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest{

    @Rule
    public ExpectedException expector = ExpectedException.none();

    @Test
    public void passengerCanBePersisted() throws Exception {
        Passenger passenger = new Passenger("1234", "testFName", "testLName", 10, null, new Date(), PassengerType.OCCASIONAL, new Date());
        entityManager().persist(passenger);
        assertNotNull(passenger.getId());
    }

    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedWithoutSSN() throws Exception {
        Passenger passenger = new Passenger(null, "testFName", "testLName", 10, null, new Date(), PassengerType.OCCASIONAL, new Date());        entityManager().persist(passenger);
    }

    @Test
    public void passengerCanBeRetrievedById() throws Exception {
        assertEquals("fname1", entityManager().find(Passenger.class, 1000L).getFirstName());
    }

    @Test
    public void allPassengersCanBeRetrieved() throws Exception {
        assertEquals(3, entityManager().createNamedQuery("Passenger.getAllPassengers").getResultList().size());
    }

    @Test
    public void isAgeCalculatedCorrectly() throws Exception {
        assertEquals(23, entityManager().find(Passenger.class, 1000L).getAge());
    }

    @Test
    public void canAddressBeAccessed() throws Exception {
        assertEquals("street1.2", entityManager().find(Passenger.class, 2000L).getAddress().getStreet1());
    }
}