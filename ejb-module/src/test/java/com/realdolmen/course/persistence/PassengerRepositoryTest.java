package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerType;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by RDEAX37 on 10/09/2015.
 */
public class PassengerRepositoryTest extends DataSetPersistenceTest{

    private PassengerRepository passengerRepo;

    @Before
    public void setUp(){
        passengerRepo = new PassengerRepository(entityManager());
    }

    @Test
    public void canPassengerBeCreated() throws Exception {
       Passenger passenger = new Passenger("1234", "testFName", "testLName", 10, null, new Date(), PassengerType.OCCASIONAL, new Date());
        passengerRepo.add(passenger);

        assertNotNull(passengerRepo.getOnSSN("1234"));
    }

    @Test
    public void canPassengerBeFoundOnSSN(){
        assertNotNull(passengerRepo.getOnSSN("98765"));
    }

    @Test
    public void canPassengerBeRetrievedById() throws Exception {
       assertNotNull(passengerRepo.getOnId(1000));
    }

    @Test
    public void canPassengerBeUpdated() throws Exception{
       Passenger passenger = passengerRepo.getOnId(2000);

        passenger.setFirstName("newFirstName");
        passengerRepo.update(passenger);

        assertEquals("newFirstName", passengerRepo.getOnId(2000).getFirstName());
    }

    @Test
    public void canPassengerBeDeleted() throws Exception {
        Passenger passenger = passengerRepo.getOnId(2000);

        passengerRepo.delete(passenger);

        assertNull(passengerRepo.getOnId(2000));
    }

    @Test
    public void canPassengerBeRefreshed() throws Exception {
        Passenger passenger = passengerRepo.getOnId(2000);

        passenger.setFirstName("newName");

        assertNotEquals("newName", passengerRepo.refresh(passenger).getFirstName());
    }

}
